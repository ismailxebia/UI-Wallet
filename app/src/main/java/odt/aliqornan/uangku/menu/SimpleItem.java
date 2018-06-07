package odt.aliqornan.uangku.menu;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import odt.aliqornan.uangku.R;

/**
 * Created by yarolegovich on 25.03.2017.
 */
public class SimpleItem extends DrawerItem<SimpleItem.ViewHolder> {

    //private int selectedItemIconTint;
    private int selectedItemLgTint;
    private int selectedItemBgTint;
    private int selectedItemTextTint;

    //private int normalItemIconTint;
    private int normalItemLgTint;
    private int normalItemBgTint;
    private int normalItemTextTint;

    //private Drawable icon;
    private Drawable lg;
    private Drawable bg;
    private String title;

    public SimpleItem(Drawable icon,Drawable lg,Drawable bg, String title) {
        //this.icon = icon;
        this.lg = lg;
        this.bg = bg;
        this.title = title;
    }

    @Override
    public ViewHolder createViewHolder(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_option, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void bindViewHolder(ViewHolder holder) {
        holder.title.setText(title);
        //holder.icon.setImageDrawable(icon);
        holder.bg.setImageDrawable(bg);
        holder.lg.setImageDrawable(lg);

        holder.title.setTextColor(isChecked ? selectedItemTextTint : normalItemTextTint);
        //holder.icon.setColorFilter(isChecked ? selectedItemIconTint : normalItemIconTint);
        holder.lg.setVisibility(isChecked ? selectedItemLgTint : normalItemLgTint);
        holder.bg.setVisibility(isChecked ? selectedItemBgTint : normalItemBgTint);
    }

    /*
    public SimpleItem withSelectedIconTint(int selectedItemIconTint) {
        this.selectedItemIconTint = selectedItemIconTint;
        return this;
    }
    */

    public SimpleItem withSelectedBgTint(int selectedItemBgTint) {
        this.selectedItemBgTint = selectedItemBgTint;
        return this;
    }

    public SimpleItem withSelectedLgTint(int selectedItemLgTint) {
        this.selectedItemLgTint = selectedItemLgTint;
        return this;
    }

    public SimpleItem withSelectedTextTint(int selectedItemTextTint) {
        this.selectedItemTextTint = selectedItemTextTint;
        return this;
    }

    /*
    public SimpleItem withIconTint(int normalItemIconTint) {
        this.normalItemIconTint = normalItemIconTint;
        return this;
    }
    */

    public SimpleItem withBgTint(int normalItemBgTint) {
        this.normalItemBgTint = normalItemBgTint;
        return this;
    }

    public SimpleItem withLgTint(int normalItemLgTint) {
        this.normalItemLgTint = normalItemLgTint;
        return this;
    }

    public SimpleItem withTextTint(int normalItemTextTint) {
        this.normalItemTextTint = normalItemTextTint;
        return this;
    }

    static class ViewHolder extends DrawerAdapter.ViewHolder {

        private ImageView icon;
        private ImageView bg;
        private ImageView lg;
        private TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            bg = (ImageView) itemView.findViewById(R.id.bg);
            lg = (ImageView)itemView.findViewById(R.id.light);
            title = (TextView) itemView.findViewById(R.id.title);
        }
    }
}
