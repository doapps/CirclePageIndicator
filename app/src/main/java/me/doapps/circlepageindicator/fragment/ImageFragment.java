package me.doapps.circlepageindicator.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import me.doapps.circlepageindicator.R;

/**
 * Created by jonathan on 10/03/2015.
 */
public class ImageFragment extends Fragment {
    public static final String IMAGE_ID = "image_id";
    public static final String IMAGE_TEXT = "image_text";

    private int imageId;
    private int imageText;

    private ImageView imageSlide;
    private TextView textSlide;

    public static ImageFragment newInstance(int imageId, int imageText){
        ImageFragment imageFragment = new ImageFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(IMAGE_ID, imageId);
        bundle.putInt(IMAGE_TEXT, imageText);
        imageFragment.setArguments(bundle);
        return imageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imageId = getArguments().getInt(IMAGE_ID);
        imageText = getArguments().getInt(IMAGE_TEXT);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image, container, false);
        imageSlide  = (ImageView)view.findViewById(R.id.imageSlide);
        textSlide = (TextView)view.findViewById(R.id.textSlide);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        imageSlide.setImageResource(imageId);
        textSlide.setText(getResources().getString(imageText));
    }
}
