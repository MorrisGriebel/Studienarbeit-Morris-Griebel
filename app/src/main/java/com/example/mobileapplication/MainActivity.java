package com.example.mobileapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.ar.core.Anchor;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.BaseArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    ArFragment arFragment;

    //Renderable - Bezeichnet ein 3D-Modell und besteht aus Eckpunkten, Materialien, Texturen
    private ModelRenderable dachsRenderable,
                            euleRenderable,
                            fuchsRenderable,
                            habichtRenderable,
                            haseRenderable,
                            hirschRenderable,
                            luchsRenderable,
                            otterRenderable,
                            wolfRenderable,
                            baerRenderable,
                            alpacaRenderable;



    TextView dachs, eule, fuchs, habicht, hase, hirsch, luchs, otter, wolf, baer, alpaca;

    View arrayView[];
    int selected = 1;


// Information welches Tier in der Array List ausgewählt wurde, als auch die gewählte Position werden gespeichert
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Verknüpfen der 3D Modelle mit deren jewiligen id's aus der xml Datei
        arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.sceneform_ux_fragment);

        dachs =  findViewById(R.id.dachs);
        eule =  findViewById(R.id.eule);
        fuchs =  findViewById(R.id.fuchs);
        habicht =  findViewById(R.id.habicht);
        hase =  findViewById(R.id.hase);
        hirsch =  findViewById(R.id.hirsch);
        luchs = findViewById(R.id.luchs);
        otter =  findViewById(R.id.otter);
        wolf =  findViewById(R.id.wolf);
        baer =  findViewById(R.id.baer);
        alpaca =  findViewById(R.id.alpaca);




        setArrayView();
        setClickListener();

        //Wird aufgerufen, wenn auf ARCore Ebene getippt wird
        //hitResult - Das ARCore-Trefferergebnis, das beim Tippen auf die Ebene aufgetreten ist
        //Plane	- Die ARCore Ebene, die getippt wurde
        //motionEvent - das Bewegungsereignis, das das Tippen ausgelöst hat

        arFragment.setOnTapArPlaneListener(new BaseArFragment.OnTapArPlaneListener() {

            @Override
            public void onTapPlane(HitResult hitResult, Plane plane, MotionEvent motionEvent) {

                //Setzten des Positionspunkts
                    Anchor anchor = hitResult.createAnchor();
                    AnchorNode anchorNode = new AnchorNode(anchor);
                    anchorNode.setParent(arFragment.getArSceneView().getScene());

                    createModel(anchorNode,selected);
            }
        });

        setupModel();
    }


    //ModelRenderable.builder konstruiert ein Renderable 3D Objekt mit den Parametern des Builders
    //Fehlermeldung wenn 3D Objekt nicht geladen werden kann
    private void setupModel() {


        ModelRenderable.builder()
                .setSource(this,R.raw.dachs)
                .build().thenAccept(renderable -> dachsRenderable = renderable)
                .exceptionally(throwable -> {
                            Toast.makeText(this, "Nicht möglich Dachs Model zu laden", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                    );


        ModelRenderable.builder()
                .setSource(this,R.raw.eule)
                .build().thenAccept(renderable -> euleRenderable = renderable)
                .exceptionally(throwable -> {
                            Toast.makeText(this, "Nicht möglich Eule Model zu laden", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(this,R.raw.fuchs)
                .build().thenAccept(renderable -> fuchsRenderable = renderable)
                .exceptionally(throwable -> {
                            Toast.makeText(this, "Nicht möglich Fuchs Model zu laden", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );


        ModelRenderable.builder()
                .setSource(this,R.raw.habicht)
                .build().thenAccept(renderable -> habichtRenderable = renderable)
                .exceptionally(throwable -> {
                            Toast.makeText(this, "Nicht möglich Habicht Model zu laden", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );


        ModelRenderable.builder()
                .setSource(this,R.raw.hase)
                .build().thenAccept(renderable -> haseRenderable = renderable)
                .exceptionally(throwable -> {
                            Toast.makeText(this, "Nicht möglich Hase Model zu laden", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );


        ModelRenderable.builder()
                .setSource(this,R.raw.hirsch)
                .build().thenAccept(renderable -> hirschRenderable = renderable)
                .exceptionally(throwable -> {
                            Toast.makeText(this, "Nicht möglich Hirsch Model zu laden", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );


        ModelRenderable.builder()
                .setSource(this,R.raw.luchs)
                .build().thenAccept(renderable -> luchsRenderable = renderable)
                .exceptionally(throwable -> {
                            Toast.makeText(this, "Nicht möglich Luchs Model zu laden", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );


        ModelRenderable.builder()
                .setSource(this,R.raw.otter)
                .build().thenAccept(renderable -> otterRenderable = renderable)
                .exceptionally(throwable -> {
                            Toast.makeText(this, "Nicht möglich Otter Model zu laden", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );



        ModelRenderable.builder()
                .setSource(this,R.raw.wolf)
                .build().thenAccept(renderable -> wolfRenderable = renderable)
                .exceptionally(throwable -> {
                            Toast.makeText(this, "Nicht möglich Wolf Model zu laden", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(this,R.raw.baer)
                .build().thenAccept(renderable -> baerRenderable = renderable)
                .exceptionally(throwable -> {
                            Toast.makeText(this, "Nicht möglich Wolf Model zu laden", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(this,R.raw.alpaca)
                .build().thenAccept(renderable -> alpacaRenderable = renderable)
                .exceptionally(throwable -> {
                            Toast.makeText(this, "Nicht möglich Wolf Model zu laden", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );
    }


    //Gerendertes 3D Objekt kann mithilfe des TransformationSystem, umsetzen, skalieren und rotieren
    private void createModel(AnchorNode anchorNode, int selected) {

        if(selected == 1)
        {

            TransformableNode dachs = new TransformableNode(arFragment.getTransformationSystem());
            dachs.setParent(anchorNode);
            dachs.setRenderable(dachsRenderable);
            dachs.select();

        }

        else if (selected == 2){

            TransformableNode eule = new TransformableNode(arFragment.getTransformationSystem());
            eule.setParent(anchorNode);
            eule.setRenderable(euleRenderable);
            eule.select();

        }

        else if (selected == 3){

            TransformableNode fuchs = new TransformableNode(arFragment.getTransformationSystem());
            fuchs.setParent(anchorNode);
            fuchs.setRenderable(fuchsRenderable);
            fuchs.select();

        }

        else if (selected == 4){

            TransformableNode habicht = new TransformableNode(arFragment.getTransformationSystem());
            habicht.setParent(anchorNode);
            habicht.setRenderable(habichtRenderable);
            habicht.select();

        }

        else if (selected == 5){

            TransformableNode hase = new TransformableNode(arFragment.getTransformationSystem());
            hase.setParent(anchorNode);
            hase.setRenderable(haseRenderable);
            hase.select();

        }

        else if (selected == 6){

            TransformableNode hirsch = new TransformableNode(arFragment.getTransformationSystem());
            hirsch.setParent(anchorNode);
            hirsch.setRenderable(hirschRenderable);
            hirsch.select();

        }

        else if (selected == 7){

            TransformableNode luchs = new TransformableNode(arFragment.getTransformationSystem());
            luchs.setParent(anchorNode);
            luchs.setRenderable(luchsRenderable);
            luchs.select();

        }

        else if (selected == 8){

            TransformableNode otter = new TransformableNode(arFragment.getTransformationSystem());
            otter.setParent(anchorNode);
            otter.setRenderable(otterRenderable);
            otter.select();

        }

        else if (selected == 9){

            TransformableNode wolf = new TransformableNode(arFragment.getTransformationSystem());
            wolf.setParent(anchorNode);
            wolf.setRenderable(wolfRenderable);
            wolf.select();

        }

        else if (selected == 10){

            TransformableNode baer = new TransformableNode(arFragment.getTransformationSystem());
            baer.setParent(anchorNode);
            baer.setRenderable(baerRenderable);
            baer.select();

        }

        else if (selected == 11){

            TransformableNode alpaca = new TransformableNode(arFragment.getTransformationSystem());
            alpaca.setParent(anchorNode);
            alpaca.setRenderable(alpacaRenderable);
            alpaca.select();

        }
    }

    //Schnittstellendefinition für einen Callback, wenn auf eine Ansicht geklickt wird
    private void setClickListener() {

        for (int i=0; i<arrayView.length;i++)
            arrayView[i].setOnClickListener(this);
    }

    //Anlegen der Array List mit den einzelnen 3D Objecten
    private void setArrayView() {

        arrayView = new View[]{

                dachs, eule, fuchs, habicht, hase, hirsch, luchs, otter, wolf, baer, alpaca
        };
    }

    //Hierachie für die Positierung in der Szene erstellen
    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.dachs)
        {
            selected = 1;
            setBackground (view.getId());
        }


        else if(view.getId() == R.id.eule)
        {
            selected = 2;
            setBackground (view.getId());
        }

        else if(view.getId() == R.id.fuchs)
        {
            selected = 3;
            setBackground (view.getId());
        }

        else if(view.getId() == R.id.habicht)
        {
            selected = 4;
            setBackground (view.getId());
        }

        else if(view.getId() == R.id.hase)
        {
            selected = 5;
            setBackground (view.getId());
        }

        else if(view.getId() == R.id.hirsch)
        {
            selected = 6;
            setBackground (view.getId());
        }

        else if(view.getId() == R.id.luchs)
        {
            selected = 7;
            setBackground (view.getId());
        }

        else if(view.getId() == R.id.otter)
        {
            selected = 8;
            setBackground (view.getId());
        }


        else if(view.getId() == R.id.wolf)
        {
            selected = 9;
            setBackground (view.getId());
        }

        else if(view.getId() == R.id.baer)
        {
            selected = 10;
            setBackground (view.getId());
        }


        else if(view.getId() == R.id.alpaca)
        {
            selected = 11;
            setBackground (view.getId());
        }
    }


    //Graue Hintergrundfarbe für die Schaltfläche des aktiven Tieres setzen
    private void setBackground(int id) {
        for(int i=0;i<arrayView.length;i++)
        {
            if(arrayView[i].getId() == id)
                arrayView[i].setBackgroundColor(Color.parseColor("#B8B8B8"));

            else
                arrayView [i]. setBackgroundColor(Color.TRANSPARENT);

        }
    }
}

