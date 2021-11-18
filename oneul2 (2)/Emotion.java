package com.example.oneul2;

import android.widget.ImageView;

public class Emotion implements Comparable<Emotion>{
    int emotion;
    //0 화남, 1 좋음, 2 행복, 3 우울, 4 슬픔, 5 그저그럼
    // angry, good, happy, moody, sad. soso
    Emotion(){

    }
    Emotion(Emotion e){
        setEmotion(e.getEmotion());
        setContents(e.getContents());
        setDate(e.getDate());
        setId(e.getId());
    }
    Emotion(int i, String c, int e, String d){
        setId(i);
        setContents(c);
        setEmotion(e);
        setDate(d);
    }

    String contents;
    String date;
    ImageView imgageView;
    int id;


    void setEmotion(int em){ emotion = em;}
    void setContents(String cont){ contents = cont; }
    void setDate(String da){ date = da; }
    void setId(int _id){id = _id;}

    int getId(){return id;}
    int getEmotion(){return emotion;}
    String getContents(){return contents;}
    String getDate(){return date;}
    ImageView getImageView(){return imgageView;}

    void setImageView(int em){
        String emotionStr;
        int emotionCode = 0;
        switch(em){
            case(0):
                emotionStr = "angry";
                emotionCode = R.drawable.fruit_angry;
                break;
            case(1):
                emotionStr = "good";
                emotionCode = R.drawable.fruit_good;
                break;
            case(2):
                emotionStr = "happy";
                emotionCode = R.drawable.fruit_happy;
                break;
            case(3):
                emotionStr = "moody";
                emotionCode = R.drawable.fruit_moody;
                break;
            case(4):
                emotionStr = "sad";
                emotionCode = R.drawable.fruit_moody;
                break;
            case(5):
                emotionStr = "soso";
                emotionCode = R.drawable.fruit_soso;
                break;
        }
        imgageView.setImageResource(emotionCode);
    }

    @Override
    public int compareTo(Emotion e) {
        String A = e.getDate();
        String B = this.getDate();
        int intA;
        int intB;
        A = A.replaceAll("-", "");
        B = B.replaceAll("-", "");

        intA = Integer.parseInt(A);
        intB = Integer.parseInt(B);

        if(intB < intA) return -1;
        else if(intB > intA) return 1;
        else return 0;
    }
}
