package com.ncr.hackspre.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ncr.hackspre.R;
import com.ncr.hackspre.model.OrderDetails;
import com.ncr.hackspre.model.RetroPosts;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class OrderDetailsAdapter extends RecyclerView.Adapter<OrderDetailsAdapter.OrderDetailsViewHolder> {

    private final Context context;

    private List<OrderDetails> orderDetails;

    public OrderDetailsAdapter(Context context, List<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
        // TODO: separate order details from order sub-structure JSON
        /*
          {
          	"Orders":[{
          		"OrderType":"Delivery",
          		"Customer":{
          			"CustomerName":"Bonny API Customer One",
          			"PhoneNumber":"555-555-5555",
          			"Email":"Bonny.Bruni@ncr.com",
          			"Address1":"1000 Any Street Address Line 1",
          			"Address2":"1000 Any Street Address Line 2",
          			"City":"Alpharetta",
          			"State":"GA",
          			"ZipCode":"30022"
                         },
          		"IsPaid":false,
          		"LineItems":[{
          			"ExternalItemId":2076627,
          			"ItemName":"COFFEE Colombia",
          			"BagName":"Bag Test One",
          			"Quantity":1,
          			"UnitPrice":2.50,
          			"UnitSellPrice":10.00,
          			"ExtendedSellPrice":10.00,
          			"Notes":["Item identified by ExternalItemId"]
                 }],
          		"Notes":[
          			"This is order not prepaid."
          			],
          		"OrderDateTime":"\/Date(1624292929000)\/",
          		"OrderDueDateTime":"\/Date(1624296529000)\/",
          		"OrderNumber":"91920172",
          		"KitchenLeadTimeInMinutes":0,
          		"TaxAmount":1.00,
          		"TipAmount":0.00* 	}],
          	"SourceApplicationName":"OnlineOrderingApp"
          }
          */
        this.context = context;
    }


    public class OrderDetailsViewHolder extends RecyclerView.ViewHolder {


        public final View orderView;

        TextView postTitle;
        TextView itemCost;
        TextView itemNumber;

        OrderDetailsViewHolder(View itemView) {
            super(itemView);

            orderView = itemView;

            postTitle = orderView.findViewById(R.id.item);
            itemCost = orderView.findViewById(R.id.itemCost);
            itemNumber = orderView.findViewById(R.id.itemNumber);
        }

    }

    @NonNull
    @NotNull
    @Override
    public OrderDetailsViewHolder onCreateViewHolder(@NonNull @NotNull final ViewGroup parent,
                                                           final int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.post_row, parent, false);
        return new OrderDetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull final OrderDetailsAdapter.OrderDetailsViewHolder holder,
                                 final int position) {
        // TODO: Insert order details into recycler view row


    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
