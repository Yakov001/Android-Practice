package com.example.recyclerviewtraining;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import API.PlaceholderAPI;
import retrofit2.Call;
import retrofit2.Retrofit;


public class CurrencyFragment extends Fragment {

    private RecyclerView currencyRecyclerView;
    private String [] currencyList;
    private CurrencyAdapter myAdapter;
    private int currencyChoice;

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,
                              Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.scroll_fragment, container, false);
        currencyRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_fragment);
        currencyRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        currencyList = getResources().getStringArray(R.array.currencies);
        myAdapter = new CurrencyAdapter();
        currencyRecyclerView.setAdapter(myAdapter);

        return view;
    }

    private class CurrencyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView currencyOne;
        private TextView currencyTwo;

        public void bind (){
            currencyOne.setText(currencyList[2]);
            currencyTwo.setText(currencyList[1]);
        }

        public CurrencyHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_currency, parent, false));
            currencyOne = (TextView) itemView.findViewById(R.id.currencyOne);
            currencyTwo = (TextView) itemView.findViewById(R.id.currencyTwo);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText( getActivity(), "Hey, dude", Toast.LENGTH_SHORT).show();
            //need to make a method to remember the clicked ViewHolder/
            currencyChoice = 0;
        }
    }

    private class CurrencyAdapter extends RecyclerView.Adapter<CurrencyHolder>{

        @NonNull
        @Override
        public CurrencyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new CurrencyHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull CurrencyHolder holder, int position) {
            holder.bind();
        }

        @Override
        public int getItemCount() {
            return getResources().getStringArray(R.array.currencies).length;
        }
    }
}
