package la.mejorando.cursosmejorandola.fragments;

import android.app.Fragment;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

import la.mejorando.cursosmejorandola.R;
import la.mejorando.cursosmejorandola.adapters.CoursesAdapter;
import la.mejorando.cursosmejorandola.models.Course;
import la.mejorando.cursosmejorandola.utils.ReadLocalJSON;

/**
 * Created by thespianartist on 23/07/14. (: pufu!!!!!
 */
public class CursosFragment extends Fragment {


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        //ReclyclerView, Adapter

        final ArrayList<Course> courses;
        ReadLocalJSON readLocalJSON = new ReadLocalJSON();
        courses = readLocalJSON.getCourses(getActivity());

        RecyclerView recyclerView = (RecyclerView) getActivity().findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new CoursesAdapter(courses, R.layout.row));


        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        
        //Por si quieren configurar algom como Grilla solo cambian la linea de arriba por esta:
        //recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));

        recyclerView.setItemAnimator(new DefaultItemAnimator());


        //Float Button

        final int size = getResources().getDimensionPixelSize(R.dimen.fab_size);
        final ImageButton imageButton = (ImageButton) getActivity().findViewById(R.id.fab_1);


        imageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Mejorando.la: Aprende a crear el futuro de la Web",
                        Toast.LENGTH_LONG).show();


            }
        });


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.cursos_fragment, container, false);
        return rootView;
    }


}
