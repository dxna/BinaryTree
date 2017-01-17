package view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.binarytree.R;

import java.util.List;

import Entry.ListEntity;


public class BinaryView extends RelativeLayout{

    public static final int TYPE_SINGLE = 1;
    public static final int TYPE_DOUBLE = 2;
    private static final String TAG = "BinaryTreeView";

    private Context mContext;
    // 最大行数
    private int mTabMaxLineNum;
    //行上的空格
    private int mTabLineSpacingNum;
    //列数
    private int mTabColumnNum = 0;
    //列上的空格
    private int mTabColumnSpacingNum;
    //单人赛还是双人赛
    private int mTabType = TYPE_SINGLE;

    private int mTextWidth = 0;
    private int mTextHeight = 0;
    private int mLineWidth = 0;

    int mViewMaxWidth = 0;
    int mViewMaxHeight = 0;

    //   测试数据
    List<List<ListEntity.EntityEntity.EliminationListEntity>> mList;

    public BinaryView(Context context) {
        super(context);
        if (isInEditMode()) {
            return;
        }
        init(context);
    }

    public BinaryView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (isInEditMode()) {
            return;
        }
        init(context);
    }

    public BinaryView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (isInEditMode()) {
            return;
        }
        init(context);
    }


    private void init(Context context) {
        this.mContext = context;
    }

    public void setData(int type, List<List<ListEntity.EntityEntity.EliminationListEntity>> eliminationList) {
        mTabType = type;
        mList = eliminationList;
        if (mList != null && mList.size() > 0) {
            initData();
            initView();
        }
    }

    private void initView() {
        for (int i = 1; i <= mTabColumnNum; i++) {//一列 最右边开始
            int tabLine = (int) Math.pow(2, i - 1);//行数
            int topMargin = 0;
            int leftMargin = 0;

            String mScore1 = "";
            String mScore2 = "";
            int mSmallScore = 0;
            int lineTop1 = 0;

            for (int j = 1; j <= tabLine; j++) {//行
                if (i == 1 && j == 1) {//第一个

                    //画线
                    View line = getLine();//第一个横线
                    LayoutParams lineParams = new LayoutParams(mLineWidth * 4 / 3, 3);
                    lineParams.topMargin = mViewMaxHeight / 2;
                    lineParams.leftMargin = mViewMaxWidth - mTextWidth * 5 / 3;
                    addView(line, lineParams);

                    if(mList.get(mList.size() - 1).size() != 2){
                        continue;
                    }
                    //写冠军的名字
                    ListEntity.EntityEntity.EliminationListEntity.MemberEntity member1 = mList.get(mList.size() - 1)//最后一个数据
                            .get(0).getMember();
                    ListEntity.EntityEntity.EliminationListEntity.MemberEntity member2 = mList.get(mList.size() - 1)//最后一个数据
                            .get(1).getMember();
//                    if(mList.get(mList.size() - 1).size() == 2){
//                        member2 = ;
//                    }
                    View view1;
                    if (member1 != null) {
                        view1 = getTextView("", member1.getName(), member1.getTeammateName());
                    } else {
                        view1 = getTextView("", "", "");
                    }
                    LayoutParams layoutParams1 = new LayoutParams(mTextWidth * 2 / 3, mTextHeight * mTabType);
                    layoutParams1.topMargin = mViewMaxHeight / 2 - mTextHeight * mTabType;
                    layoutParams1.leftMargin = mViewMaxWidth - mTextWidth;
                    addView(view1, layoutParams1);


                    //写第一名.和第二名
                    View No1 = getRankTextView("第一名");
                    LayoutParams No1Params = new LayoutParams(mTextWidth * 2 / 3, mTextHeight);
                    No1Params.topMargin = mViewMaxHeight / 2;
                    No1Params.leftMargin = mViewMaxWidth - mTextWidth;
                    addView(No1, No1Params);

                    View No2 = getRankTextView("第二名");
                    LayoutParams No2Params = new LayoutParams(mTextWidth * 2 / 3, mTextHeight);
                    No2Params.topMargin = mViewMaxHeight / 2;
                    No2Params.leftMargin = mViewMaxWidth - mTextWidth * 2 + mTextWidth / 3;
                    addView(No2, No2Params);
                    //第二名名字
                    View view2;
                    if (member2 != null) {
                        view2 = getTextView("", member2.getName(), member2.getTeammateName());
                    } else {
                        view2 = getTextView("", "", "");
                    }
                    LayoutParams layoutParams2 = new LayoutParams(mTextWidth * 2 / 3, mTextHeight * mTabType);
                    layoutParams2.topMargin = mViewMaxHeight / 2 - mTextHeight * mTabType;
                    layoutParams2.leftMargin = mViewMaxWidth - mTextWidth * 5 / 3;
                    addView(view2, layoutParams2);

                    //写比分
                    ListEntity.EntityEntity.EliminationListEntity.MemberEntity member3 = mList.get(mList.size() - 2)
                            .get(0).getMember();//最后一个数据
                    ListEntity.EntityEntity.EliminationListEntity.MemberEntity member4 = mList.get(mList.size() - 2)
                            .get(1).getMember();//最后一个数据
                    View view3;

                    if (member3 != null && member4 != null) {
                        String str = member3.getScore() + ":" + member4.getScore();
                        mSmallScore = mList.get(mList.size() - 2).get(0).smallscore;
                        if (mSmallScore != 0) {
                            str = str + "(" + mSmallScore + ")";
                        }
                        mSmallScore = 0;
                        view3 = getScoreTextView(str);
                    } else {
                        view3 = getScoreTextView("");
                    }
                    LayoutParams layoutParams3 = new LayoutParams(mTextWidth, mTextHeight);
                    layoutParams3.topMargin = mViewMaxHeight / 2 - mTextHeight / 2;
                    layoutParams3.leftMargin = mViewMaxWidth - mTextWidth * 10 / 4;
                    addView(view3, layoutParams3);


                } else {
                    final ListEntity.EntityEntity.EliminationListEntity.MemberEntity member =
                            mList.get(mTabColumnNum - i).get(j - 1).getMember();
                    View view2;
                    //如果是最左边的一列,加上编号
                    String no = "";
                    int lineW = mLineWidth;
                    if (i == mTabColumnNum) {
                        no = j + "";
                        lineW = mLineWidth * 2 ;
                    }
                    if (member != null) {
                        view2 = getTextView(no, member.getName(), member.getTeammateName());
                    } else {
                        view2 = getTextView(no, "", "");
                    }

                    LayoutParams layoutParams2 = new LayoutParams(lineW , mTextHeight * mTabType);
                    layoutParams2.topMargin = (int) (mViewMaxHeight * ((2 * j - 1) / Math.pow(2, i)) - mTextHeight * mTabType);
                    layoutParams2.leftMargin = mViewMaxWidth - i * mTextWidth + mLineWidth - lineW;

                    int top = (int) (mViewMaxHeight * ((2 * j - 1) / Math.pow(2, i)) - mTextHeight / 2);
                    int left = mViewMaxWidth - i * mTextWidth + mLineWidth - lineW;
                    addView(view2, layoutParams2);

                    //划线
                    if (j % 2 == 1) {
                        View line = getLine();//第一个横线

                        LayoutParams layoutParams3 = new LayoutParams(lineW, 3);
                        layoutParams3.topMargin = layoutParams2.topMargin + mTextHeight * mTabType;
                        layoutParams3.leftMargin = layoutParams2.leftMargin;
//                        if (i == mTabColumnNum) {
//                            layoutParams3.leftMargin = layoutParams2.leftMargin - mTextHeight * mTabType ;
//                        }
                        topMargin = layoutParams2.topMargin + mTextHeight  * mTabType;
                        leftMargin = layoutParams3.leftMargin;
                        addView(line, layoutParams3);
                        lineTop1 = layoutParams3.topMargin;

                        if (member != null) {
                            mScore1 = String.valueOf(member.getScore());
                            mSmallScore = mList.get(mTabColumnNum - i).get(j - 1).smallscore;
                        }
                    } else if (j % 2 == 0) {
                        View line = getLine();//第二个横线

                        LayoutParams layoutParams3 = new LayoutParams(lineW, 3);
                        layoutParams3.topMargin = top + mTextHeight / 2;
                        layoutParams3.leftMargin = left;

//                        if (i == mTabColumnNum) {
//                            layoutParams3.leftMargin = left - mTextHeight * mTabType;
//                        }
                        addView(line, layoutParams3);

                        //画竖线
                        View columnLine = getLine();
                        LayoutParams layoutParams4 = new LayoutParams(3, layoutParams3.topMargin - topMargin);
                        layoutParams4.topMargin = topMargin ;
                        layoutParams4.leftMargin = leftMargin + lineW ;
                        addView(columnLine, layoutParams4);


                        if (member != null) {
                            mScore2 = String.valueOf(member.getScore());
                        }
                        if (i != 2) {//倒数第二列不写比如
                            //比分
                            if (!TextUtils.isEmpty(mScore1) && !TextUtils.isEmpty(mScore2)) {
                                String str = mScore1 + ":" + mScore2;
                                mScore1 = "";
                                mScore2 = "";
                                if(mSmallScore != 0){
                                    str = str + "(" + mSmallScore + ")";
                                }
                                View scoreTextView = getScoreTextView(str);
                                LayoutParams lp = new LayoutParams(lineW , mTextHeight / 2);
                                lp.topMargin = lineTop1 + (layoutParams3.topMargin - lineTop1) / 2 - mTextHeight * mTabType / 2;
                                lp.leftMargin = layoutParams3.leftMargin;
                                addView(scoreTextView, lp);
                            }
                        }
                        mSmallScore = 0;
                    }

                }
            }
        }
    }

    private void initData() {
        //列的数量
        mTabColumnNum = mList.size();
        //行的成员数量
        mTabMaxLineNum = (int) Math.pow(2, mTabColumnNum - 1);

        if (mTabMaxLineNum < 2) {//最少两行
            return;
        }
        //TextView的宽度
//        if (mList.get(0) != null && mList.get(0).get(0) != null && mList.get(0).get(0).getMember() != null && null != mList.get(0).get(0).getMember().getTeammateName()) {
//            mTabType = TYPE_DOUBLE;
//        }
        mTextWidth = dip2px(80);
        //线的长度
        mLineWidth = dip2px(80);
        //间隔
        mTabLineSpacingNum = mTabMaxLineNum + 1;

//      mTabColumnSpacingNum = mTabColumnNum - 1;
        //View的宽度

        mViewMaxWidth = (mTabColumnNum - 1) * mTextWidth + mLineWidth * 2;
        //高度30
        mTextHeight = dip2px(30);

        //整体高度
        mViewMaxHeight = mTabMaxLineNum * mTabType * mTextHeight + mTabLineSpacingNum * dip2px(30);
        Log.i(TAG, "mViewMaxHeight:" + mViewMaxHeight + ",mViewMaxWidth:" + mViewMaxWidth);
    }

    private View getTextView(String no, String name1, String name2) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.view_node_label, null);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(mTextWidth, mTextHeight);
        inflate.setLayoutParams(layoutParams);

        TextView t1 = (TextView) inflate.findViewById(R.id.mTvName1);
        TextView t2 = (TextView) inflate.findViewById(R.id.mTvName2);
        TextView mTvNo = (TextView) inflate.findViewById(R.id.mTvNo);
        t1.setHeight(mTextHeight);
        if(!TextUtils.isEmpty(no) && TextUtils.isEmpty(name1)){
            name1 = "None";
            if(TYPE_DOUBLE == mTabType){
                name2 = "None";
            }
        }
        t1.setText(name1);

        t1.setWidth(mTextWidth);
        t2.setWidth(mTextWidth);
        t1.setGravity(Gravity.CENTER);
        t2.setGravity(Gravity.CENTER);
        if (TYPE_DOUBLE == mTabType) {
            t2.setVisibility(View.VISIBLE);
            t2.setText(name2);
        } else {
            t1.setHeight(mTextHeight);
            t2.setVisibility(View.GONE);
            t2.setText("");
        }
        if (TextUtils.isEmpty(no)) {
            mTvNo.setVisibility(View.GONE);
        } else {
            mTvNo.setVisibility(View.VISIBLE);
            mTvNo.setText(no);
        }
        return inflate;
    }

    private TextView getScoreTextView(String text) {
        TextView textView = new TextView(mContext);
        textView.setWidth(mLineWidth / 2);
        textView.setHeight(mTextHeight * 2 / 3);
        if("0:0".equals(text)){
            text = "";
        }
        textView.setText(text);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(getResources().getColor(R.color.Cr_333333));
        return textView;
    }

    private TextView getRankTextView(String text) {
        TextView textView = new TextView(mContext);
        textView.setWidth(mLineWidth / 2);
        textView.setHeight(mTextHeight / 2);
        textView.setText(text);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(10);
        textView.setTextColor(getResources().getColor(R.color.Cr_333333));
        return textView;
    }

    public int dip2px(float dip) {
        float f = mContext.getResources().getDisplayMetrics().density;
        return (int) (dip * f + 0.5F);
    }

    private View getLine() {
        View view = new View(mContext);
        view.setBackgroundResource(android.R.color.darker_gray);
        return view;
    }
}
