package moj.tvz.hr.listatopolovec;

import android.os.Parcel;
import android.os.Parcelable;

public class PhotoAndDetails implements Parcelable {

    private String photo;
    private String details;

    protected PhotoAndDetails(Parcel in) {
        this.photo = in.readString();
        this.details = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.photo);
        dest.writeString(this.details);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PhotoAndDetails> CREATOR = new Creator<PhotoAndDetails>() {
        @Override
        public PhotoAndDetails createFromParcel(Parcel in) {
            return new PhotoAndDetails(in);
        }

        @Override
        public PhotoAndDetails[] newArray(int size) {
            return new PhotoAndDetails[size];
        }
    };

    public PhotoAndDetails(String photo, String details) {
        this.photo = photo;
        this.details = details;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
