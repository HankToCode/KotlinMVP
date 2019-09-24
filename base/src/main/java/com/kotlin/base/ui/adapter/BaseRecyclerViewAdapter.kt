package com.kotlin.base.ui.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView

/**
 * @author:     张荣东
 * @date:       2019年9月3日11:47:34
 * @desciption: RecyclerViewAdapter基类
 */
abstract class BaseRecyclerViewAdapter<T, VH : RecyclerView.ViewHolder>(var mContext: Context) :
    RecyclerView.Adapter<VH>() {

    //ItemClick事件
    var mOnItemClickListener: OnItemClickListener<T>? = null

    var dataList: MutableList<T> = mutableListOf()

    /**
     * 设置数据
     * Presenter处理过为null的情况，所以为不会为Null
     */
    fun setData(sources: MutableList<T>) {
        dataList = sources
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.itemView.setOnClickListener {
            mOnItemClickListener?.onItemClick(dataList[position], position)
        }

    }


    /**
     * ItemClick事件声明
     */
    interface OnItemClickListener<in T> {
        fun onItemClick(item: T, position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener<T>) {
        this.mOnItemClickListener = listener
    }

}