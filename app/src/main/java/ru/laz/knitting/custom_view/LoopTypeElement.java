package ru.laz.knitting.custom_view;

/**
 * Created by Dmitry Lazarev on 17.04.2018.
 */
public class LoopTypeElement {

    private String loopType;
    private String imageLoopType;


    public LoopTypeElement(String loopT, String imgLoop) {
        loopType = loopT;
        imageLoopType = imgLoop;
    }

    public void setLoopType(String loopType) {
        this.loopType = loopType;
    }

    public void setImageLoopType(String imageLoopType) {
        this.imageLoopType = imageLoopType;
    }

    public String getLoopType() {
        return loopType;
    }

    public String getImageLoopType() {
        return imageLoopType;
    }
}
