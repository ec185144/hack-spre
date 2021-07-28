package com.ncr.hackspre;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.zxing.ResultPoint;
import com.journeyapps.barcodescanner.BarcodeCallback;
import com.journeyapps.barcodescanner.BarcodeResult;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class ScannerActivity extends AppCompatActivity {

    public static final String EXTRA_CUSTOMER = "com.ncr.hackspre.CUSTOMER";

    DecoratedBarcodeView dbvScanner;
    LoyaltyRewards rewards1, rewards2, rewards3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);

        dbvScanner = (DecoratedBarcodeView) findViewById(R.id.cameraView);

        // get camera permission
        requestPermission();

        // continuous barcode reader
        dbvScanner.getStatusView().setPadding(16, 0, 16, 0);
        dbvScanner.decodeContinuous(new BarcodeCallback() {
            @Override
            public void barcodeResult(final BarcodeResult result) {
                // send text to customer lookup
                //Result r = result.getResult();
                //onBarcode(r.getText());
                // make beep sound

            }

            @Override
            public void possibleResultPoints(final List<ResultPoint> resultPoints) {

            }
        });

        // set barcode reader visibility to false
    }

    /*
     *   onBarcode(String barcode)
     *   - calls done() to lookup barcode text
     *
     */
    public void onBarcode(View view) {
        EditText editText = (EditText) findViewById(R.id.barcodeText);
        String barcode = editText.getText().toString();
        done(barcode, "Barcode");
    }

    /*
     *   done(String lookupText, String state)
     *   - determines what to lookup based on state.
     *      * Customer: if employee needs to override, lookup a String of manually entered customer info
     *      * Barcode: if customer provides actual barcode, create BarcodeInfo class
     *   - call getCustomerLookup() to look up whatever was passed
     *
     */
    public void done(String lookupText, String state) {
        //String phoneNumber = "";
        String barcodeInfo = "";

        switch (state) {
            /*case "Manual":
                phoneNumber = lookupText;
                break;
             */
            case "Barcode":
                barcodeInfo = lookupText;
                break;
        }

        getCustomerLookup(barcodeInfo);
    }

    /*
     *   getCustomerLookup(String manuallyEnteredNumber, BarcodeInfo barcodeInfo)
     *   - lookup text in customer list. If customer is found, open OpenScreen
     *
     */
    public void getCustomerLookup(String barcodeInfo) {
        ArrayList<Customer> list = new ArrayList<>();
        for (Customer customer : generateCustomers()) {
            if (barcodeInfo.equalsIgnoreCase(customer.memberID)) {
                /* assign customer to ticket
                   assignCustomerToTicket(customer);
                 */
                openOrderScreen(customer);
            }
        }
    }

    public ArrayList<Customer> generateCustomers() {
        ArrayList<Customer> customerList = new ArrayList<>();
        generateLoyaltyRewards();

        Customer cust1 = new Customer("1234", "Jane", "jane@email.com", "4044444444", rewards1);
        Customer cust2 = new Customer("4321", "John", "john@email.com", "4044044044", rewards2);
        Customer cust3 = new Customer("2121", "Emma", "emma@email.com", "4044004000", rewards3);
        customerList.add(cust1);
        customerList.add(cust2);
        customerList.add(cust3);

        return customerList;
    }

    public void generateLoyaltyRewards() {
        rewards1 = new LoyaltyRewards("1234", 500);
        rewards2 = new LoyaltyRewards("4321", 1000);
        rewards3 = new LoyaltyRewards("2121", 730);
    }

    public void openOrderScreen(Customer customer) {
        Intent intent = new Intent(ScannerActivity.this, MainActivity.class);
        intent.putExtra(EXTRA_CUSTOMER, (Parcelable) customer);
        startActivity(intent);
    }

    public void requestPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
            != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CAMERA}, 0);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 0 && grantResults.length < 1) {
            requestPermission();
        } else {
            dbvScanner.resume();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        resumeScanner();
    }

    protected void resumeScanner() {
        boolean isScanDone = false;
        if (!dbvScanner.isActivated()) {
            dbvScanner.resume();
        }
        Log.d("scanner-pause", "paused: false");
    }

    protected void pauseScanner() {
        dbvScanner.pause();
    }

    @Override
    protected void onPause() {
        super.onPause();
        pauseScanner();
    }
}