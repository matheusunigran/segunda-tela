package br.unigran.hello.fragmento;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.unigran.hello.Entidades.Fornecedor;
import br.unigran.hello.R;
import br.unigran.hello.bancoDados.DBHelper;
import br.unigran.hello.bancoDados.FornecedorDB;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FornecedorListaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FornecedorListaFragment extends Fragment {
    FornecedorDB fornecedorDB;
    DBHelper db;
    List<Fornecedor> dados;
    ListView fornecedorList;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FornecedorListaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FornecedorListaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FornecedorListaFragment newInstance(String param1, String param2) {
        FornecedorListaFragment fragment = new FornecedorListaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fornecedor_lista, container, false);

        fornecedorList = (ListView) view.findViewById(R.id.listviewFornecedorID);
        dados = new ArrayList<>();

        ArrayAdapter arrayAdapter = new ArrayAdapter(
                getActivity(),
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, dados);
        fornecedorList.setAdapter(arrayAdapter);

        db = new DBHelper(getActivity());
        fornecedorDB = new FornecedorDB(db);

        fornecedorDB.lista(dados);

        return view;
    }
}