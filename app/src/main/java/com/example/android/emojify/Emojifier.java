package com.example.android.emojify;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;

import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

public class Emojifier {

    static void detectFaces(Context context, Bitmap bitmap){
        //crating a frame instance
        Frame frame = new Frame.Builder().setBitmap(bitmap).build();


        FaceDetector detector = new FaceDetector.Builder(context)
                .setTrackingEnabled(false)
                .setLandmarkType(FaceDetector.ALL_LANDMARKS)
                .build();

        //Calling the detector synchronously
        SparseArray<Face> faces = detector.detect(frame);

        Log.i("Faces -----------", String.valueOf(faces.size()));
    }
}
