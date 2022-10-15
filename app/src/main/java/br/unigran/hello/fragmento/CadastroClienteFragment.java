package br.unigran.hello.fragmento;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.unigran.hello.Entidades.Cliente;
import br.unigran.hello.R;
import br.unigran.hello.bancoDados.ClienteDB;
import br.unigran.hello.bancoDados.DBHelper;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CadastroClienteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CadastroClienteFragment extends Fragment {

    EditText nome;
    EditText numero;
    Button btsalvar;

    DBHelper db;
    ClienteDB clienteDB;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CadastroClienteFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CadastroClienteFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CadastroClienteFragment newInstance(String param1, String param2) {
        CadastroClienteFragment fragment = new CadastroClienteFragment();
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
            Toast.makeText(getActivity(), "Preencha os dados", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }

    public void salvar() {
       if(verificar()){
            Cliente cliente = new Cliente();

            cliente.setNome(nome.getText().toString());
            cliente.setNumero(numero.getText().toString());

            clienteDB.inserir(cliente);
            Toast.makeText(getActivity(), "Dados salvos com sucesso!", Toast.LENGTH_SHORT).show();

            // Redirect to list fragment
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.idframe, new ClienteListaFragment())
                    .addToBackStack(null)
                    .commit();
        }
    }
    private void limpar() {
        nome.setText("");
        numero.setText("");
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cadastro_cliente, container, false);

        db = new DBHelper(getActivity());
        clienteDB = new ClienteDB(db);
        nome = view.findViewById(R.id.nomeID);
        numero = view.findViewById(R.id.numeroID);
        btsalvar = view.findViewById(R.id.btCadastrarFornecedorID);

        btsalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvar();
                limpar();
            }
        });
        return view;
    }
}