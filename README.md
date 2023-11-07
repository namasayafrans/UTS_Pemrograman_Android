# Android Studio - Deret Bilangan Fibonanci 

Nama   : Frans Putra Sinaga

Nim    : 312210046

Kelas  : TI22A1 

Matkul : Pemrograman Mobile 1

Dosen  : Donny Maulana S.kom M.M.SI

## Menu <br>
| No | Description | Link |
|-----|------|-----|
|1|MainActivity.java|[Click Here](#mainactivityjava)|
|2|activy_main.xml|[Click Here](#activity_mainxml)|
|3|strings.xml|[Click Here](#stringsxml)|
|4|colors.xml|[Click Here](#colorsxml)|
|5|running|[Click Here](#running)|

## MainActivity.java 
cara membuka MainActivity.java  yaitu app -> java -> com.toast -> MainActivity.java
```
package com.toast;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.app.AlertDialog;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private TextView showCount;
    private int count = 1;
    private long fibNMinus1 = 1;
    private long fibNMinus2 = 0;
    private int limit = -1;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showCount = findViewById(R.id.show_count);
    }
    public void countUp(View view) {
        if (count == 0){
            showCount.setText("0");
        } else if (count == 1) {
            showCount.setText("1");
        } else {
            if (limit != -1 && count > limit ){
                count = 0;
                fibNMinus1 = 1;
                fibNMinus2 = 0;
                showCount.setText(getString(R.string.count_initial_value));
            } else {
            long fibCurrent = fibNMinus1 + fibNMinus2;
            fibNMinus2 = fibNMinus1;
            fibNMinus1 = fibCurrent;

                int colorResId = R.color.color1; // Warna default
                switch (count % 3) {
                    case 1:
                        colorResId = R.color.color1; // Warna merah
                        break;
                    case 2:
                        colorResId = R.color.color2; // Warna hijau
                        break;
                    case 0:
                        colorResId = R.color.color3; // Warna biru
                        break;
                }
                showCount.setTextColor(getResources().getColor(colorResId));
            showCount.setText(String.valueOf(fibCurrent));
            }
        }
        count++;
    }


    public void back1(View view) {
        count = 1;
        fibNMinus1 = 1;
        fibNMinus2 = 0;
        showCount.setText(getString(R.string.count_initial_value));
    }

    public void setLimit(View view) {
        // Create and display a dialog to set the limit
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Set Limit");

        final EditText input = new EditText(this);
        input.setInputType(android.text.InputType.TYPE_CLASS_NUMBER);
        builder.setView(input);

        builder.setPositiveButton("OK", (dialog, which) -> {
            String limitStr = input.getText().toString();
            limit = Integer.parseInt(limitStr);
        });
        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());
        builder.show();
    }
}
```

## activity_main.xml
cara membuka activity_main.xml yaitu app -> res -> layout -> activity_main.xml
```
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <Button
        android:id="@+id/button_toast"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginStart="8dp"
        android:layout_marginTop="8dp"
        android:layout_marginEnd="8dp"
        android:background="@color/colorPrimary"
        android:hint="@string/button_label_toast"
        android:onClick="setLimit"
        android:textColor="@android:color/white"
        android:textColorHint="#BBDEFB"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        tools:ignore="UsingOnClickInXml,VisualLintButtonSize" />

    <Button
        android:id="@+id/button_count"
        android:layout_width="190dp"
        android:layout_height="48dp"
        android:layout_marginEnd="8dp"
        android:layout_marginStart="8dp"
        android:layout_marginTop="8dp"
        android:background="@color/colorPrimary"
        android:onClick="countUp"
        android:text="@string/button_label_count"
        android:textColor="@android:color/white"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.0"
        tools:ignore="UsingOnClickInXml,VisualLintButtonSize"
         />

    <Button
        android:id="@+id/button_finish"
        android:layout_width="190dp"
        android:layout_height="48dp"
        android:layout_marginEnd="8dp"
        android:layout_marginStart="8dp"
        android:layout_marginTop="8dp"
        android:background="@color/colorPrimary"
        android:onClick="back1"
        android:text="@string/button_label_finish"
        android:textColor="@android:color/white"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintHorizontal_bias="1.0"
        app:layout_constraintBottom_toBottomOf="parent"
        tools:ignore="UsingOnClickInXml,VisualLintButtonSize"
        />
    <TextView
        android:id="@+id/show_count"
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:layout_marginStart="8dp"
        android:layout_marginTop="8dp"
        android:layout_marginEnd="8dp"
        android:background="#FFFF00"
        android:gravity="center_vertical"
        android:text="@string/count_initial_value"
        android:textAlignment="center"
        android:textColor="@color/colorPrimary"
        android:textSize="160sp"
        android:textStyle="bold"
        app:layout_constraintBottom_toTopOf="@id/button_count"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@id/button_toast"
        />
</androidx.constraintlayout.widget.ConstraintLayout>
```

## strings.xml
cara buka strings.xml yaitu app -> res -> values -> strings.xml
```
<resources>
    <string name="app_name">Fibonanci</string>
    <string name="button_label_toast">Limited angka</string>
    <string name="button_label_count">Count</string>
    <string name="count_initial_value">0</string>
    <string name="toast_message">Bilangan Fibonanci</string>
    <string name="button_label_finish">reset</string>
</resources>
```

## colors.xml
cara buka colors.xml yaitu app -> res -> values -> colors.xml
```
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <color name="black">#FF000000</color>
    <color name="white">#FFFFFFFF</color>
    <color name="colorPrimary">#3F5185</color>
    <color name="colorPrimaryDark">#303F9F</color>
    <color name="colorAccent">#FF4081</color>
    <color name="color1">#FF0000</color>
    <color name="color2">#00FF00</color>
    <color name="color3">#0000FF</color>   
</resources>
```

## Running 
cara menjalkan program yaitu siapkan android / emulator android -> lihat di sebel  kanan ada bacccan nama device/ android kkita -> klik logo run 
dan ini hasil nya 



https://github.com/namasayafrans/UTS_Pemrograman_Android/assets/115770839/b4b43825-011a-4c38-828c-b31180970d30



## Thank_you_and_see_you_again 
createed by Frans Putra Sinaga

