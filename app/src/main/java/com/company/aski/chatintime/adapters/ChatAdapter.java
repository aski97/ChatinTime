package com.company.aski.chatintime.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.company.aski.chatintime.ChatActivity;
import com.company.aski.chatintime.R;
import com.company.aski.chatintime.datamodel.Chat;
import com.company.aski.chatintime.datamodel.Messaggio;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {

    private Context context;
    private List<Chat> listaChat;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private TextView txtNomeDestinatario;
        private TextView txtTesto;
        private ImageView imgDestinatario;
        private CardView cardViewChat;

        public ViewHolder(View itemView) {
            super(itemView);
            txtNomeDestinatario=itemView.findViewById(R.id.txtDestinatarioChat);
            txtTesto=itemView.findViewById(R.id.txtAnteprimaTestoChat);
            imgDestinatario=itemView.findViewById(R.id.imgDestinatarioChat);
            cardViewChat=itemView.findViewById(R.id.cardViewChat);
        }
    }

    public ChatAdapter(Context context, List<Chat> listaChat) {
        this.context = context;
        this.listaChat = listaChat;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public ChatAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.chat_item_layout,parent,false);
        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final Chat chat= listaChat.get(position);
        int nMessaggi= chat.getMessaggi().size();
        Messaggio lastMessaggio= chat.getMessaggi().get(nMessaggi-1);
        //Bisogna di un if per capire se lui è creatore o destinatario
        //se sono il creatore della chat allora devo visualizzare il destinatario
        //altrimenti devo visualizzare il creatore, poiché sono il destinatario.
        holder.txtNomeDestinatario.setText(chat.getNomeDestinatario());
        //il testo deve cambiare in base a se è una foto o altri cazzi,
        //si deve cambiare colore nel caso in cui il messaggio è nuovo.
        holder.txtTesto.setText(lastMessaggio.getTestoMessaggio());
        holder.imgDestinatario.setImageDrawable(context.getDrawable(R.drawable.ic_account_circle_black_24dp));
        holder.cardViewChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ChatActivity.class);
                intent.putExtra("NomeTitolo",chat.getNomeDestinatario());
                context.startActivity(intent);
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return listaChat.size();
    }
}
