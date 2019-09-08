package com.nehaimgurdemoapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.nehaimgurdemoapp.adapter.ImageAdapter;
import com.nehaimgurdemoapp.model.Datum;
import com.nehaimgurdemoapp.model.response.ImageListResponse;
import com.nehaimgurdemoapp.retrofit.ServiceGenerator;
import com.nehaimgurdemoapp.services.ImagesNetworkService;
import com.nehaimgurdemoapp.utils.Constants;
import com.nehaimgurdemoapp.utils.DateUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private ProgressBar progressBar;
    private SearchView mSearchView;
    private RecyclerView recyclerView;
    private SwitchCompat viewSwitch;
    private ListView mSearchListView;
    private ImageListResponse evenImageList = new ImageListResponse();
    private ImageListResponse allImageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Set the toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Imgur Demo");
        setSupportActionBar(toolbar);

        // Call to the method to initialise the UI variables
        setupUIView();

        // Call to the method to set the search view properties
        setupSearchView();

        // Call to the method to set the toggle button properties
        setUpSwitchView();
    }

    // Method to initialise the UI variables
    private void setupUIView() {
        recyclerView = findViewById(R.id.my_recycler_view);
        progressBar = findViewById(R.id.progressBar);
        mSearchView = findViewById(R.id.search_view);
        mSearchListView = findViewById(R.id.listView1);
        viewSwitch = findViewById(R.id.view_swt);
        progressBar.setVisibility(View.GONE);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
    }

    // Method to setup search view
    private void setupSearchView() {
        mSearchView.setIconifiedByDefault(false);
        mSearchView.setOnQueryTextListener(this);
        mSearchView.setSubmitButtonEnabled(true);
        mSearchView.setQueryHint("Enter text to search");
    }

    // Method to setup the toggle button
    private void setUpSwitchView() {
        viewSwitch.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            if (evenImageList != null && evenImageList.getData() != null) {
                                // call to the method to set adapter with the even sum of the 'scope', 'point', and 'topic_id'
                                setResponseToListAdapter(getReverseImageListByTime(evenImageList.getData()));
                            }
                        } else {
                            if (allImageList != null) {
                                // call to the method to set adapter with all the images of the response
                                setResponseToListAdapter(getReverseImageListByTime(allImageList.getData()));
                            }
                        }
                    }
                });
    }


    /**
     * @param dataList
     * Method to set images and its details to the list
     */
    private void setResponseToListAdapter(List<Datum> dataList) {
        if (recyclerView != null) {
            progressBar.setVisibility(View.GONE);
            RecyclerView.Adapter mAdapter = new ImageAdapter(dataList, this, new ImageAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(Datum item) {
                    openImageDetailPopUp(item);
                }
            });
            recyclerView.setAdapter(mAdapter);
            mAdapter.notifyDataSetChanged();
        }

    }


    /**
     * @param imageList
     * @return imageList
     * Method to show the list with sorted
     * in reverse chronological order
     */
    private List<Datum> getReverseImageListByTime(List<Datum> imageList) {
        // Sort the list according to the date and time of the image
        Collections.sort(imageList, new Comparator<Datum>() {
            public int compare(Datum image1, Datum image2) {
                if (image1.getDatetime() == null || image2.getDatetime() == null)
                    return 0;
                return (DateUtil.getDateTime(image1.getDatetime())).compareTo(DateUtil.getDateTime((image2.getDatetime())));
            }
        });
        // Reverse the sorted list to get chronological order
        Collections.reverse(imageList);
        return imageList;
    }


    /**
     * @param dataList
     * Method to get images where the sum of “points”,
     * “score” and “topic_id” adds up to an even number
     */
    private void checkForEvenCount(ArrayList<Datum> dataList) {
        List<Datum> mEvenList = new ArrayList<Datum>();
        for (int i = 0; i < dataList.size(); i++) {
            Datum item = dataList.get(i);
            int totalSum = item.getPoints() + item.getScore() + item.getTopicId();
            // Check whether total count is even or not
            if (totalSum % 2 == 0) {
                mEvenList.add(item);
            }
        }
        evenImageList.setData(mEvenList);
    }


    /**
     * @param item
     * Method to open a popup window to
     * show the details of the image when clicked
     */
    private void openImageDetailPopUp(Datum item) {
        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_window, null);
        TextView imageDetailTv = popupView.findViewById(R.id.image_detail_tv);
        imageDetailTv.setText(String.format("Id: %s\n" +
                "Title: %s\n" +
                "Date of upload: %s\n" +
                "Image Count: %d\n" +
                "Comment Count: %d\n" +
                "Views: %d\n" +
                "Votes: %s\n" +
                "Points: %d\n" +
                "Topic: %s\n" +
                "Topic Id: %d", item.getId(), item.getTitle(), DateUtil.getDateTime(item.getDatetime()), item.getImagesCount(), item.getCommentCount() != null ? item.getCommentCount() : 0, item.getViews(), item.getVote() != null ? item.getVote() : 0, item.getPoints() != null ? item.getPoints() : 0, item.getTopic(), item.getTopicId() != null ? item.getTopicId() : 0));
        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);

        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    }

    /**
     * @param text
     * Method to call the network service
     * to get the image list based on the text entered by user
     */
    private void callImageSearchNetworkService(String text) {
        ImagesNetworkService networkService = ServiceGenerator.createService(ImagesNetworkService.class, Constants.CLIENT_ID);

        // Call the network service to get the data
        Call<ImageListResponse> result = networkService.getSearchedImageList(Constants.TOP, Constants.WEEK, text);

        result.enqueue(new Callback<ImageListResponse>() {
            @Override
            public void onResponse(@NonNull Call<ImageListResponse> call, @NonNull Response<ImageListResponse> response) {
                allImageList = response.body();

                ArrayList<Datum> myList = new ArrayList<Datum>();
                if (allImageList.getData() != null) {
                    for (int i = 0; i < allImageList.getData().size(); i++) {
                        Datum item = allImageList.getData().get(i);
                        if (item != null) {
                            // Check only for jpeg and png images not gif,mp4 etc.
                            if (item.getImagesCount() != null && (item.getImages().get(0).getType().equalsIgnoreCase("image/jpeg") || item.getImages().get(0).getType().equalsIgnoreCase("image/png")))
                                myList.add(item);
                        }
                    }
                    checkForEvenCount(myList);
                    recyclerView.setVisibility(View.VISIBLE);
                    setResponseToListAdapter(getReverseImageListByTime(myList));
                }
            }

            @Override
            public void onFailure(@NonNull Call<ImageListResponse> call, @NonNull Throwable t) {
                Log.e(Constants.TAG, "Error " + t.getMessage());
                if (t.getMessage().contains("Unable to resolve host")) {
                    Toast.makeText(MainActivity.this, getString(R.string.network_issue), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

        });

    }


    @Override
    public boolean onQueryTextSubmit(String s) {
        if(progressBar!=null)
           progressBar.setVisibility(View.VISIBLE);
        // Call network service method
        callImageSearchNetworkService(s);
        return false;
    }


    @Override
    public boolean onQueryTextChange(String newText) {
        if (TextUtils.isEmpty(newText)) {
            mSearchListView.clearTextFilter();
            recyclerView.setVisibility(View.VISIBLE);
        } else {
            recyclerView.setVisibility(View.GONE);
        }
        return false;
    }
}
