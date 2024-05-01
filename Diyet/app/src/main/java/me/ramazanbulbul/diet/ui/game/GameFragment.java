package me.ramazanbulbul.diet.ui.game;

import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.ramazanbulbul.diet.MainActivity;
import me.ramazanbulbul.diet.R;

public class GameFragment extends Fragment {
    private GameViewModel gameViewModel;
    boolean isCart = true;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        gameViewModel =
                ViewModelProviders.of(this).get(GameViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_game, container, false);
        final Button btn = root.findViewById(R.id.button1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isCart = true;
                Toast.makeText(root.getContext(), "Kartlar Karıştırılıyor..", Toast.LENGTH_SHORT).show();

                Integer[] sayiList = new Integer[16];
                sayiList[0] = 1;
                sayiList[1] = 1;
                sayiList[2] = 2;
                sayiList[3] = 2;
                sayiList[4] = 3;
                sayiList[5] = 3;
                sayiList[6] = 4;
                sayiList[7] = 4;
                sayiList[8] = 5;
                sayiList[9] = 5;
                sayiList[10] = 6;
                sayiList[11] = 6;
                sayiList[12] = 7;
                sayiList[13] = 7;
                sayiList[14] = 8;
                sayiList[15] = 8;
                int id = 0;
                Random rnd = new Random();
                for (ImageView iView : GetImageList(root)){
                    id++;

                    iView.setVisibility(View.VISIBLE);
                    iView.setImageResource(R.drawable.gambler);

                    Integer[] tag = new Integer[3];
                    tag[0] = id;
                    int n = rnd.nextInt(sayiList.length);
                    while (sayiList[n] == 0){
                        n = rnd.nextInt(sayiList.length);
                    }
                    tag[1] = sayiList[n];
                    sayiList[n] = 0;
                    tag[2] = 0;
                    iView.setTag(tag);
                }
            }
        });

        for (ImageView iView: GetImageList(root)){
            iView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(GetImageList(root)[0].getTag() == null){
                        Toast.makeText(root.getContext(), "Lütfen oyunu başlatınız", Toast.LENGTH_SHORT).show();
                    }


                    ImageView imageView = (ImageView) view;
                    Integer[] tagList1 = (Integer[]) view.getTag();


                    if(isCart){
                        imageView.setImageResource(R.drawable.gambler);
                        tagList1[2] = 0;
                        imageView.setTag(tagList1);
                        for(ImageView imageView2 : GetImageList(root)){
                            Integer[] tagList = (Integer[]) imageView2.getTag();
                            if(tagList[2] == 1){
                                imageView2.setImageResource(R.drawable.gambler);
                                tagList[2] = 0;
                                imageView2.setTag(tagList);
                            }
                        }
                    }

                    switch (tagList1[1]){
                        case 1:
                            imageView.setImageResource(R.drawable.cherries);
                            break;
                        case 2:
                            imageView.setImageResource(R.drawable.drunk);
                            break;
                        case 3:
                            imageView.setImageResource(R.drawable.eggplant);
                            break;
                        case 4:
                            imageView.setImageResource(R.drawable.orange);
                            break;
                        case 5:
                            imageView.setImageResource(R.drawable.pear);
                            break;
                        case 6:
                            imageView.setImageResource(R.drawable.salad);
                            break;
                        case 7:
                            imageView.setImageResource(R.drawable.strawberry);
                            break;
                        case 8:
                            imageView.setImageResource(R.drawable.tangerine);
                            break;
                    }

                    tagList1[2] = 1;

                    Integer[] tagList2 = null;
                    boolean isGame = false;
                    for (ImageView iView : GetImageList(root)){
                        tagList2 = (Integer[]) iView.getTag();
                        if(!tagList1[0].equals(tagList2[0])){
                            if(tagList2[2] == 1){
                                if(tagList1[1].equals(tagList2[1])){
                                    view.setVisibility(View.INVISIBLE);
                                    iView.setVisibility(View.INVISIBLE);
                                    tagList1[2] = 2;
                                    tagList2[2] = 2;
                                    view.setTag(tagList1);
                                    iView.setTag(tagList2);
                                }
                            }

                        }
                        Integer[] tagList = (Integer[]) iView.getTag();
                        if(tagList[2] == 0 || tagList[2] == 1){
                            isGame = true;
                            break;
                        }
                    }
                    if (!isGame){
                        Toast.makeText(root.getContext(), tagList1[0] + "_" + tagList1[1] + "_" + tagList1[2] + "_", Toast.LENGTH_SHORT).show();
                    }

                    isCart = !isCart;

                    Toast.makeText(root.getContext(), tagList1[0] + "_" + tagList1[1] + "_" + tagList1[2] + "_", Toast.LENGTH_SHORT).show();
                }
            });

        }
        return root;
    }

    public ImageView[] GetImageList(View view){
        ImageView[] image = new ImageView[16];
        ImageView imageView1 = view.findViewById(R.id.imageView1);
        ImageView imageView2 = view.findViewById(R.id.imageView2);
        ImageView imageView3 = view.findViewById(R.id.imageView3);
        ImageView imageView4 = view.findViewById(R.id.imageView4);
        ImageView imageView5 = view.findViewById(R.id.imageView5);
        ImageView imageView6 = view.findViewById(R.id.imageView6);
        ImageView imageView7 = view.findViewById(R.id.imageView7);
        ImageView imageView8 = view.findViewById(R.id.imageView8);
        ImageView imageView9 = view.findViewById(R.id.imageView9);
        ImageView imageView10 = view.findViewById(R.id.imageView10);
        ImageView imageView11 = view.findViewById(R.id.imageView11);
        ImageView imageView12 = view.findViewById(R.id.imageView12);
        ImageView imageView13 = view.findViewById(R.id.imageView13);
        ImageView imageView14 = view.findViewById(R.id.imageView14);
        ImageView imageView15 = view.findViewById(R.id.imageView15);
        ImageView imageView16 = view.findViewById(R.id.imageView16);
        image[0] = imageView1;
        image[1] = imageView2;
        image[2] = imageView3;
        image[3] = imageView4;
        image[4] = imageView5;
        image[5] = imageView6;
        image[6] = imageView7;
        image[7] = imageView8;
        image[8] = imageView9;
        image[9] = imageView10;
        image[10] = imageView11;
        image[11] = imageView12;
        image[12] = imageView13;
        image[13] = imageView14;
        image[14] = imageView15;
        image[15] = imageView16;
        return image;
    }
}
