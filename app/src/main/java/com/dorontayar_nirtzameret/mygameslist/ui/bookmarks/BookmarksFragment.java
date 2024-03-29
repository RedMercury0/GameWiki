package com.dorontayar_nirtzameret.mygameslist.ui.bookmarks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.dorontayar_nirtzameret.mygameslist.databinding.FragmentBookmarksBinding;


public class BookmarksFragment extends Fragment {

    private FragmentBookmarksBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        BookmarksViewModel bookmarksViewModel =
                new ViewModelProvider(this).get(BookmarksViewModel.class);

        binding = FragmentBookmarksBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textBookmarks;
        bookmarksViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}