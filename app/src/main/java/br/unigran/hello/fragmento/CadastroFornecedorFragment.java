package br.unigran.hello.fragmento;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import br.unigran.hello.Entidades.Cliente;
import br.unigran.hello.Entidades.Fornecedor;
import br.unigran.hello.R;
import br.unigran.hello.bancoDados.ClienteDB;
import br.unigran.hello.bancoDados.DBHelperCliente;
import br.unigran.hello.bancoDados.DBHelperFornecedor;
import br.unigran.hello.bancoDados.FornecedorDB;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CadastroFornecedorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CadastroFornecedorFragment extends Fragment {


    EditText nome;
    EditText numero;
    List<Cliente> dados;

    DBHelperFornecedor db;
    FornecedorDB fornecedorDB;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CadastroFornecedorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CadastroFornecedorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CadastroFornecedorFragment newInstance(String param1, String param2) {
        CadastroFornecedorFragment fragment = new CadastroFornecedorFragment();
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

    //verifica se o usuário colocou um item com as informações corretas
    public boolean verificar() {
        String nomeCliente = nome.getText().toString();
        String numeroCliente = numero.getText().toString();

        if ((nomeCliente.equals(null) || nomeCliente.equals(null) || numeroCliente.equals(null))
                || (numeroCliente.equals(""))) {
            return false;
        } else {
            return true;
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        /*View view = inflater.inflate(R.layout.fragment_cadastro_cliente, container, false);
        nome = view.findViewById(R.id.nomeID);
        numero = view.findViewById(R.id.marcaID);
        dados = new ArrayList<>();

        //db = new DBHelperCliente(this);

        fornecedorDB = new FornecedorDB(db);
        fornecedorDB.lista(dados);//lista incial

        return view;*/

        return inflater.inflate(R.layout.fragment_cadastro_fornecedor, container, false);
    }

    public void salvar(View view) {
        if (verificar()) {
            Fornecedor fornecedor = new Fornecedor();

            fornecedor.setNome(nome.getText().toString());
            fornecedor.setNumero(numero.getText().toString());

            fornecedorDB.inserir(fornecedor);
            fornecedorDB.lista(dados);

        }
    }
}