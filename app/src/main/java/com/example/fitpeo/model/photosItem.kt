package com.example.fitpeo.model

import android.os.Parcel
import android.os.Parcelable

data class photosItem(
    val albumId: Int,
    val id: Int,
    val thumbnailUrl: String?,
    val title: String?,
    val url: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(albumId)
        parcel.writeInt(id)
        parcel.writeString(thumbnailUrl)
        parcel.writeString(title)
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<photosItem> {
        override fun createFromParcel(parcel: Parcel): photosItem {
            return photosItem(parcel)
        }

        override fun newArray(size: Int): Array<photosItem?> {
            return arrayOfNulls(size)
        }
    }
}