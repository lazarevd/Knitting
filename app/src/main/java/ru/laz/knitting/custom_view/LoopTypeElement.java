package ru.laz.knitting.custom_view;

/**
 * Created by Dmitry Lazarev on 17.04.2018.
 */
public class LoopTypeElement {

    private String loopName;
    private String loopDescr;
    private String loopImg;


    public LoopTypeElement(String loopName, String loopDescr, String loopImg) {
        this.loopName = loopName;
        this.loopDescr = loopDescr;
        this.loopImg = loopImg;
    }

    public void setLoopName(String loopName) {
        this.loopName = loopName;
    }

    public void setLoopDescr(String loopDescr) {
        this.loopDescr = loopDescr;
    }

    public void setLoopImg(String loopImg) {
        this.loopImg = loopImg;
    }

    public String getLoopName() {
        return loopName;
    }

    public String getLoopDescr() {
        return loopDescr;
    }

    public String getLoopImg() {
        return loopImg;
    }
}
