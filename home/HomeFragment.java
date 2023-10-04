package com.unimelb.aichatbot.ui.home;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.unimelb.aichatbot.R;
import com.unimelb.aichatbot.databinding.FragmentHomeBinding;
import com.unimelb.aichatbot.ui.chatHistory.ItemFragment;
import com.unimelb.aichatbot.ui.chatHistory.placeholder.PlaceholderContent;
import com.unimelb.aichatbot.ui.login_signup.choose_chara;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.home_layout, container, false);

        TextView  seeMoreButton = root.findViewById(R.id.see_more);
        ItemFragment itemFragment = (ItemFragment) getParentFragmentManager().findFragmentById(R.id.chatHistory);

        //@SuppressLint({"MissingInflatedId", "LocalSuppress"}) RecyclerView  recyclerView = root.findViewById(R.id.chat_list);

        //add rest of list items
        seeMoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlaceholderContent.toggleItems();
                //adapter.notifyDataSetChanged();
                Log.d("PlaceholderContent", itemFragment.toString() );
                    itemFragment.updateRecyclerView();


            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}