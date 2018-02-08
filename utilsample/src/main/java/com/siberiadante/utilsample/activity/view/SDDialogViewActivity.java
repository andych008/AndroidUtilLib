package com.siberiadante.utilsample.activity.view;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.siberiadante.androidutil.view.dialog.BottomItemDialog;
import com.siberiadante.androidutil.view.dialog.CustomDialog;
import com.siberiadante.androidutil.view.dialog.EditDialog;
import com.siberiadante.androidutil.view.dialog.EnsureDialog;
import com.siberiadante.utilsample.R;
import com.siberiadante.utilsample.activity.base.BaseActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class SDDialogViewActivity extends BaseActivity {


    @BindView(R.id.btn_general_dialog_one)
    Button btnGeneralDialogOne;
    @BindView(R.id.btn_general_dialog_two)
    Button btnGeneralDialogTwo;
    @BindView(R.id.btn_general_dialog_three)
    Button btnGeneralDialogThree;
    @BindView(R.id.btn_general_dialog_four)
    Button btnGeneralDialogFour;
    @BindView(R.id.btn_bottom_popup_widow)
    Button btnBottomPopupWidow;
    @BindView(R.id.btn_edit_dialog)
    Button btnEditDialog;
    @BindView(R.id.btn_custom_dialog)
    Button btnCustomDialog;
    @BindView(R.id.btn_sd_custom_dialog)
    Button btnSdCustomDialog;

    private EnsureDialog ensureDialog;


    @Override
    public int setLayoutId() {
        return R.layout.activity_sddialog_view;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

    }

    @OnClick({R.id.btn_general_dialog_one, R.id.btn_general_dialog_two, R.id.btn_general_dialog_three, R.id.btn_general_dialog_four, R.id.btn_bottom_popup_widow, R.id.btn_edit_dialog, R.id.btn_custom_dialog, R.id.btn_sd_custom_dialog})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_general_dialog_one:
                showEnsureDialogOne();
                break;
            case R.id.btn_general_dialog_two:
                showEnsureDialogTwo();
                break;
            case R.id.btn_general_dialog_three:
                showEnsureDialogThree();
                break;
            case R.id.btn_general_dialog_four:
                showEnsureDialogFour();
                break;
            case R.id.btn_bottom_popup_widow:
                showBottomPopupWindow();
                break;
            case R.id.btn_edit_dialog:
                showEditDialog();
                break;
            case R.id.btn_custom_dialog:
                showCustomDialog();
                break;
            case R.id.btn_sd_custom_dialog:
                showSDCustomEditDialog();
                break;
        }
    }

    /**
     * EditDialog
     */
    private void showEditDialog() {
        final EditDialog dialog = new EditDialog(this).builder();
        dialog.setTitle("可编辑Dialog");
        dialog.setCancelable(false);
        dialog.setNegativeButton("取消", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        dialog.setPositiveButton("确定", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String msg = dialog.getMsg();
                Toast.makeText(SDDialogViewActivity.this, "输入内容为：" + msg, Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    /**
     * BottomItemDialog
     */
    private void showBottomPopupWindow() {
        new BottomItemDialog(this).builder()
                .setCancelable(false).setCanceled(true)//setTitle("选择").
                .addSheetItem("相机", BottomItemDialog.SheetItemColor.BLACK, new BottomItemDialog.OnSheetItemClickListener() {
                    @Override
                    public void onClick(int which) {
                        //需要对相机进行运行时权限的申请
                    }
                })
                .addSheetItem("相册", BottomItemDialog.SheetItemColor.BLACK, new BottomItemDialog.OnSheetItemClickListener() {
                    @Override
                    public void onClick(int which) {
                        //调用手机相册的方法,该方法在下面有具体实现
                    }
                })
                .addSheetItem("时光机", BottomItemDialog.SheetItemColor.BLACK, new BottomItemDialog.OnSheetItemClickListener() {
                    @Override
                    public void onClick(int which) {

                    }
                })
                .show();
    }

    /**
     * EnsureDialog
     */
    private void showEnsureDialogOne() {
        ensureDialog = new EnsureDialog(this).builder()
                .setGravity(Gravity.CENTER)//默认居中，可以不设置
                .setTitle("这里是一个标题", getResources().getColor(R.color.sdColorBlack))//可以不设置标题颜色，默认系统颜色
                .setCancelable(false)
                .setNegativeButton("取消", new View.OnClickListener() {//可以选择设置颜色和不设置颜色两个方法
                    @Override
                    public void onClick(View view) {

                    }
                })
                .setPositiveButton("确认", getResources().getColor(R.color.sdColorRed), new View.OnClickListener() {//可以选择设置颜色和不设置颜色两个方法
                    @Override
                    public void onClick(View view) {
                        ensureDialog.dismiss();

                    }
                });
        ensureDialog.show();

    }

    private void showEnsureDialogTwo() {
        ensureDialog = new EnsureDialog(this).builder()
                .setGravity(Gravity.CENTER)//默认居中，可以不设置
                .setTitle("这里是一个标题", getResources().getColor(R.color.sdColorBlack))//可以不设置标题颜色，默认系统颜色
                .setSubTitle("这是一个副标题")
                .setCancelable(false)
                .setNegativeButton("取消", new View.OnClickListener() {//可以选择设置颜色和不设置颜色两个方法
                    @Override
                    public void onClick(View view) {

                    }
                })
                .setPositiveButton("确认", getResources().getColor(R.color.sdColorRed), new View.OnClickListener() {//可以选择设置颜色和不设置颜色两个方法
                    @Override
                    public void onClick(View view) {
                        ensureDialog.dismiss();

                    }
                });
        ensureDialog.show();

    }

    private void showEnsureDialogThree() {
        ensureDialog = new EnsureDialog(this).builder()
                .setGravity(Gravity.CENTER)//默认居中，可以不设置
                .setTitle("这里是一个标题", getResources().getColor(R.color.sdColorBlack))//可以不设置标题颜色，默认系统颜色
                .setIncon(R.drawable.icon_tips)//不设置图标，默认没有图标
                .setCancelable(false)
                .setNegativeButton("取消", new View.OnClickListener() {//可以选择设置颜色和不设置颜色两个方法
                    @Override
                    public void onClick(View view) {

                    }
                })
                .setPositiveButton("确认", getResources().getColor(R.color.sdColorRed), new View.OnClickListener() {//可以选择设置颜色和不设置颜色两个方法
                    @Override
                    public void onClick(View view) {
                        ensureDialog.dismiss();

                    }
                });
        ensureDialog.show();

    }

    private void showEnsureDialogFour() {
        ensureDialog = new EnsureDialog(this).builder()
                .setGravity(Gravity.CENTER)//默认居中，可以不设置
                .setTitle("这里是一个标题", R.color.sdColorBlack)//可以不设置标题颜色，默认系统颜色
                .setCancelable(false)
                .setCenterButton("取消", new View.OnClickListener() {//可以选择设置颜色和不设置颜色两个方法
                    @Override
                    public void onClick(View view) {

                    }
                })
        ;
        ensureDialog.show();
    }

    private void showCustomDialog() {
        CustomDialog customDialog = new CustomDialog(this, R.layout.dialog_sd_custom);
        customDialog.show();
    }

    /**
     * 这种方式使用中的缺陷就是需要资源id需要一一对应
     */
    private void showSDCustomEditDialog() {
        final CustomDialog customDialog = new CustomDialog(this,
                R.layout.dialog_sd_custom,
                new int[]{R.id.btn_cancel, R.id.btn_sure, R.id.edt_content, R.id.edt_sub_content},
                0,
                false,
                false,
                Gravity.CENTER);
        customDialog.setOnDialogItemClickListener(new CustomDialog.OnCustomDialogItemClickListener() {
            @Override
            public void OnCustomDialogItemClick(CustomDialog dialog, View view) {
                switch (view.getId()) {
                    case R.id.btn_cancel:
                        customDialog.dismiss();
                        break;
                    case R.id.btn_sure:

                        break;
                }
            }
        });

        customDialog.show();
        final List<View> viewList = customDialog.getViews();
        final Button btnSure = (Button) viewList.get(1);
        btnSure.setTextColor(ContextCompat.getColor(this, R.color.colorGray));
        final EditText edtContent = (EditText) viewList.get(2);
        final EditText edtSubContent = (EditText) viewList.get(3);
        edtContent.setHint("这是一个主内容");
        edtSubContent.setHint("这是一个副内容");
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
