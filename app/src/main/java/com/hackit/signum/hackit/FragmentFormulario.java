package com.hackit.signum.hackit;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;

import com.yalantis.starwars.TilesFrameLayout;
import com.yalantis.starwars.interfaces.TilesFrameLayoutListener;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentFormulario.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class FragmentFormulario extends Fragment implements TilesFrameLayoutListener {

    private OnFragmentInteractionListener mListener;

    private TilesFrameLayout mTilesFrameLayout;
    private EditText etCodigo;
    private TextInputLayout tilCodigo;

    public FragmentFormulario() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_formulario, container, false);
        mTilesFrameLayout = (TilesFrameLayout) vista.findViewById(R.id.tiles_frame_layout);
        mTilesFrameLayout.setOnAnimationFinishedListener(this);
        etCodigo = (EditText) vista.findViewById(R.id.etCodigo);
        tilCodigo = (TextInputLayout) vista.findViewById(R.id.tilCodigo);
        vista.findViewById(R.id.bComprobar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (etCodigo.getText().toString().trim().equals(getResources().getString(Params.CODAHACK))) {
                    mTilesFrameLayout.startAnimation();
                } else {
                    tilCodigo.setError(getString(R.string.error_codigo));
                    etCodigo.setText("");
                }
            }
        });
        return vista;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onAnimationFinished() {
        getActivity().findViewById(R.id.tvEstado).setVisibility(View.VISIBLE);
        TextView tvEstado = (TextView) getActivity().findViewById(R.id.tvEstado);
        Animation myFadeInAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.blink);
        tvEstado.setText(getString(R.string.codigo_correcto));
        tvEstado.startAnimation(myFadeInAnimation);


    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onResume() {
        super.onResume();
        mTilesFrameLayout.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mTilesFrameLayout.onPause();
    }
}
