package com.shop.fruitsbasket

import android.os.Parcel
import android.os.Parcelable

class Fruit( val fruitName: String?,  val fruitImage:Int,  val fruitPrice:Int, val details:String?):Parcelable
{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString()
    ) {
    }


    companion object CREATOR : Parcelable.Creator<Fruit> {
        override fun createFromParcel(parcel: Parcel): Fruit {
            return Fruit(parcel)
        }

        override fun newArray(size: Int): Array<Fruit?> {
            return arrayOfNulls(size)
        }
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        p0?.writeString(fruitName)
        p0?.writeInt(fruitImage)
        p0?.writeInt(fruitPrice)
        p0?.writeString(details)

    }
}