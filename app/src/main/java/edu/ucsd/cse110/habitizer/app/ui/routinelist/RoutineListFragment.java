package edu.ucsd.cse110.habitizer.app.ui.routinelist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import edu.ucsd.cse110.habitizer.app.ui.tasklist.TaskListFragment;

import java.util.ArrayList;
import java.util.List;

import edu.ucsd.cse110.habitizer.app.MainViewModel;

import edu.ucsd.cse110.habitizer.app.R;
import edu.ucsd.cse110.habitizer.app.databinding.FragmentRoutineListBinding;
import edu.ucsd.cse110.habitizer.lib.domain.MockElapsedTimer;

public class RoutineListFragment extends Fragment {
    private MainViewModel activityModel;
    private FragmentRoutineListBinding view;

    public RoutineListFragment() {}

    public static RoutineListFragment newInstance() {
        RoutineListFragment fragment = new RoutineListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstance) {
        super.onCreate(savedInstance);

        var modelOwner = requireActivity();
        var modelFactory = ViewModelProvider.Factory.from(MainViewModel.initializer);
        var modelProvider = new ViewModelProvider(modelOwner, modelFactory);
        this.activityModel = modelProvider.get(MainViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.view = FragmentRoutineListBinding.inflate(inflater, container, false);

        view.morningRoutineButton.setOnClickListener(v -> {
            var modelOwner = requireActivity();
            this.activityModel.setRoutineName("Morning");
            modelOwner.getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, TaskListFragment.newInstance())
                    .commit();
        });

        view.eveningRoutineButton.setOnClickListener(v -> {
            var modelOwner = requireActivity();
            this.activityModel.setRoutineName("Evening");
            modelOwner.getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, TaskListFragment.newInstance())
                    .commit();
        });
        return view.getRoot();
    }
}
