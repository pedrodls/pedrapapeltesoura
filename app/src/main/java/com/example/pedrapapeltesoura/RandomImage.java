package com.example.pedrapapeltesoura;

import android.graphics.drawable.Drawable;

public class RandomImage {

    private String option;
    private int imageId;

    public RandomImage(String option, int imageId) {
        this.option = option;
        this.imageId = imageId;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
