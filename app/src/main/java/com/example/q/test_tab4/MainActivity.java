package com.example.q.test_tab4;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ListView m_oListView = null;
    private ArrayList<ArrayList<String>> mGroupList = null;
    private ArrayList<String> mChildList = null;
    String[] strNumber = {"111-1111-1111", "111-1111-1111", "111-1111-1111", "111-1111-1111", "111-1111-1111",
            "111-1111-1111", "111-1111-1111", "111-1111-1111", "111-1111-1111","111-1111-1111"};
    String[] strName={"b1","b2","b3","b4","b5","b6","b7","b8","b9","b10"};
    String[] strCode={"a1","a2","a3","a4","a5","a6","a7","a8","a9","a10"};
    String[] strNation={"korea","america","canada","japan","korea","korea","swiss","japan","uk","korea"};
    TextView user;
    TextView computer;
    TextView result;
    TextView textA;
    ProgressBar progress;
    int resultInt=50;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = (TextView)findViewById(R.id.textUser);
        computer = (TextView)findViewById(R.id.textComputer);
        result = (TextView)findViewById(R.id.textResult);
        Button buttonA = (Button)findViewById(R.id.buttonA);
        Button buttonB = (Button)findViewById(R.id.buttonB);
        Button buttonC = (Button)findViewById(R.id.buttonC);
        Button buttonK=(Button)findViewById(R.id.buttonK);
        Button buttonZ=(Button)findViewById(R.id.buttonZ);
        progress = (ProgressBar) findViewById(R.id.progress) ;

        textA = (TextView)findViewById(R.id.textA);

        buttonA.setOnClickListener(this);
        buttonB.setOnClickListener(this);
        buttonC.setOnClickListener(this);
        buttonK.setOnClickListener(this);
        buttonZ.setOnClickListener(this);

        Button button3=(Button) findViewById(R.id.button3);
        ArrayList<ItemData> oData = new ArrayList<>();

        int nDatCnt=0;
        for (int i=0; i<strName.length; ++i)
        {
            ItemData oItem = new ItemData();
            oItem.name = strName[nDatCnt];
            oItem.nation=strNation[nDatCnt];
            oItem.code=strCode[nDatCnt];
            oItem.number = strNumber[nDatCnt++];
            oItem.onClickListener = this;
            if (oItem.code=="a1") {
                oItem.imgld = R.drawable.a1;
            }
            else if(oItem.code=="a2"){
                oItem.imgld = R.drawable.a2;
            }
            else if(oItem.code=="a3"){
                oItem.imgld = R.drawable.a3;
            }
            else if(oItem.code=="a4"){
                oItem.imgld = R.drawable.a4;
            }
            else if(oItem.code=="a5"){
                oItem.imgld = R.drawable.a5;
            }
            else if(oItem.code=="a6"){
                oItem.imgld = R.drawable.a6;
            }
            else if(oItem.code=="a7"){
                oItem.imgld = R.drawable.a7;
            }
            else if(oItem.code=="a8"){
                oItem.imgld = R.drawable.a8;
            }
            else if(oItem.code=="a9"){
                oItem.imgld = R.drawable.a9;
            }
            else if(oItem.code=="a10"){
                oItem.imgld = R.drawable.a10;
            }
            else{
                oItem.imgld=R.drawable.china;
            }

            oData.add(oItem);
            if (nDatCnt >= strNumber.length) nDatCnt = 0;
        }
        m_oListView = (ListView)findViewById(R.id.listView);
        ListAdapter oAdapter = new ListAdapter(oData);
        m_oListView.setAdapter(oAdapter);















        TabHost tabHost1 = (TabHost) findViewById(R.id.tabHost1) ;
        tabHost1.setup() ;

        // 첫 번째 Tab. (탭 표시 텍스트:"TAB 1"), (페이지 뷰:"content1")
        TabHost.TabSpec ts1 = tabHost1.newTabSpec("Tab Spec 1") ;
        ts1.setContent(R.id.content1) ;
        ts1.setIndicator("TAB 1") ;
        tabHost1.addTab(ts1)  ;

        // 두 번째 Tab. (탭 표시 텍스트:"TAB 2"), (페이지 뷰:"content2")
        TabHost.TabSpec ts2 = tabHost1.newTabSpec("Tab Spec 2") ;
        ts2.setContent(R.id.content2) ;
        ts2.setIndicator("TAB 2") ;
        tabHost1.addTab(ts2) ;

        // 세 번째 Tab. (탭 표시 텍스트:"TAB 3"), (페이지 뷰:"content3")
        TabHost.TabSpec ts3 = tabHost1.newTabSpec("Tab Spec 3") ;
        ts3.setContent(R.id.content3) ;
        ts3.setIndicator("TAB 3") ;
        tabHost1.addTab(ts3) ;



    }
    @Override
    public void onClick(View v)
    {
        int offsetX=0;
        int offsetY=0;
        Toast toast;
        Intent intent;
        String comX;           // 컴퓨터가 낸 걸 보관하는 장소
        String userX;          // 사람이 낸 걸 보관하는 장소
        String resultX;        // 승패 결과를 보관하는 장소
        // 컴퓨터 가위 바위 보 선택
        Random r;
        float f;


        View oParentView;
        TextView name;
        TextView number;
        String position;
        int p;
        String nation;
        String number2;
        String strMsg;
        switch(v.getId()){

            case R.id.button3:
                oParentView = (View)v.getParent();
                position = (String) oParentView.getTag();
                p=Integer.valueOf(position);
                number2=strNumber[p];
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:"+number2));
                startActivity(intent);
                break;
            case R.id.btnSelector:
                oParentView = (View)v.getParent();
                name = (TextView) oParentView.findViewById(R.id.Name);
                number = (TextView) oParentView.findViewById(R.id.Number);
                position = (String) oParentView.getTag();
                p=Integer.valueOf(position);
                nation= strNation[p];
                number2=strNumber[p];
                AlertDialog.Builder oDialog = new AlertDialog.Builder(this,
                        android.R.style.Theme_DeviceDefault_Light_Dialog);
                strMsg="이름: "+name.getText()+"\n"+"전화번호: "+number.getText()+"\n"+"국적: "+ nation;
                oDialog.setMessage(strMsg)
                        .setPositiveButton("확인", null)
                        .setCancelable(true) // 백버튼으로 팝업창이 닫히지 않도록 한다.
                        .show();
                break;

            case R.id.buttonK:
                intent= new Intent(getApplicationContext(),
                        Next.class
                );
                if (resultInt>=50){
                    intent.putExtra("승자","플레이어");
                    intent.putExtra("점수",resultInt);
                    intent.putExtra("day","y-m-d");
                    //Toast.makeText(getApplicationContext(),"하이 짧게", Toast.LENGTH_SHORT).show();
                    toast=Toast.makeText(getApplicationContext(),"you win"+"\n"+"저장되었습니다", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, offsetX,offsetY);
                    toast.show();
                }
                else{
                    intent.putExtra("승자","컴퓨터");
                    intent.putExtra("점수",resultInt);
                    //Toast.makeText(getApplicationContext(),"하이 짧게", Toast.LENGTH_SHORT).show();
                    toast=Toast.makeText(getApplicationContext(),"you lose"+"\n"+"저장되었습니다", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, offsetX,offsetY);
                    toast.show();
                }
                startActivity(intent);
                break;
            case R.id.buttonZ:
                finish();
                break;
            case R.id.buttonA:
                comX = "";           // 컴퓨터가 낸 걸 보관하는 장소
                userX = "";          // 사람이 낸 걸 보관하는 장소
                resultX = "";        // 승패 결과를 보관하는 장소
                // 컴퓨터 가위 바위 보 선택
                r = new Random();
                f = r.nextFloat();
                if(f<0.333){
                    comX = "가위";
                } else if (f<0.666){
                    comX = "바위";
                } else {
                    comX = "보";
                }
                computer.setText(comX);     // 컴퓨터가 낸 걸 화면에 표시

                // 사람 가위 바위 보 선택 (누른 버튼에 따라)
                switch(v.getId()) {
                    case R.id.buttonA:
                        userX = "가위";
                        break;
                    case R.id.buttonB:
                        userX = "바위";
                        break;
                    case R.id.buttonC:
                        userX = "보";
                        break;
                }
                user.setText(userX);    // 사람이 낸 걸 화면에 표시

                // 컴퓨터랑 사람의 승패 결정
                if(userX.equals("가위")){     // 사람이 가위를 낸 경우
                    if(comX.equals("가위"))
                        resultX = "비겼어요!!";
                    else if (comX.equals("바위"))
                        resultX = "컴퓨터 승리!!";
                    else        // 컴퓨터가 보를 낸 경우
                        resultX = "플레이어 승리!!";
                } else if(userX.equals("바위")){  // 사람이 바위를 낸 경우
                    if(comX.equals("가위"))
                        resultX = "플레이어 승리!!";
                    else if (comX.equals("바위"))
                        resultX = "비겼어요!!";
                    else        // 컴퓨터가 보를 낸 경우
                        resultX = "컴퓨터 승리!!";
                } else if(userX.equals("보")){       // 사람이 보를 낸 경우
                    if(comX.equals("가위"))
                        resultX = "컴퓨터 승리!!";
                    else if (comX.equals("바위"))
                        resultX = "플레이어 승리!!";
                    else        // 컴퓨터가 보를 낸 경우
                        resultX = "비겼어요!!";
                }
                if (resultX.equals("플레이어 승리!!")){
                    if(userX.equals("가위")){
                        resultInt=resultInt+15;
                    }
                    else if(userX.equals("바위")){
                        resultInt=resultInt+5;
                    }
                    else if(userX.equals("보")){
                        resultInt=resultInt+25;
                    }
                }
                else if (resultX.equals("컴퓨터 승리!!")){
                    if(comX.equals("가위")){
                        resultInt=resultInt-15;
                    }
                    else if(comX.equals("바위")){
                        resultInt=resultInt-5;
                    }
                    else if(comX.equals("보")){
                        resultInt=resultInt-25;
                    }
                }
                result.setText(resultX);    // 승패 결과를 화면에 표시
                progress.setProgress(resultInt) ;
                textA.setText(" "+resultInt);
                break;

            case R.id.buttonB:
                comX = "";           // 컴퓨터가 낸 걸 보관하는 장소
                userX = "";          // 사람이 낸 걸 보관하는 장소
                resultX = "";        // 승패 결과를 보관하는 장소
                // 컴퓨터 가위 바위 보 선택
                r = new Random();
                f = r.nextFloat();
                if(f<0.333){
                    comX = "가위";
                } else if (f<0.666){
                    comX = "바위";
                } else {
                    comX = "보";
                }
                computer.setText(comX);     // 컴퓨터가 낸 걸 화면에 표시

                // 사람 가위 바위 보 선택 (누른 버튼에 따라)
                switch(v.getId()) {
                    case R.id.buttonA:
                        userX = "가위";
                        break;
                    case R.id.buttonB:
                        userX = "바위";
                        break;
                    case R.id.buttonC:
                        userX = "보";
                        break;
                }
                user.setText(userX);    // 사람이 낸 걸 화면에 표시

                // 컴퓨터랑 사람의 승패 결정
                if(userX.equals("가위")){     // 사람이 가위를 낸 경우
                    if(comX.equals("가위"))
                        resultX = "비겼어요!!";
                    else if (comX.equals("바위"))
                        resultX = "컴퓨터 승리!!";
                    else        // 컴퓨터가 보를 낸 경우
                        resultX = "플레이어 승리!!";
                } else if(userX.equals("바위")){  // 사람이 바위를 낸 경우
                    if(comX.equals("가위"))
                        resultX = "플레이어 승리!!";
                    else if (comX.equals("바위"))
                        resultX = "비겼어요!!";
                    else        // 컴퓨터가 보를 낸 경우
                        resultX = "컴퓨터 승리!!";
                } else if(userX.equals("보")){       // 사람이 보를 낸 경우
                    if(comX.equals("가위"))
                        resultX = "컴퓨터 승리!!";
                    else if (comX.equals("바위"))
                        resultX = "플레이어 승리!!";
                    else        // 컴퓨터가 보를 낸 경우
                        resultX = "비겼어요!!";
                }
                if (resultX.equals("플레이어 승리!!")){
                    if(userX.equals("가위")){
                        resultInt=resultInt+15;
                    }
                    else if(userX.equals("바위")){
                        resultInt=resultInt+5;
                    }
                    else if(userX.equals("보")){
                        resultInt=resultInt+25;
                    }
                }
                else if (resultX.equals("컴퓨터 승리!!")){
                    if(comX.equals("가위")){
                        resultInt=resultInt-15;
                    }
                    else if(comX.equals("바위")){
                        resultInt=resultInt-5;
                    }
                    else if(comX.equals("보")){
                        resultInt=resultInt-25;
                    }
                }
                result.setText(resultX);    // 승패 결과를 화면에 표시
                progress.setProgress(resultInt) ;
                textA.setText(" "+resultInt);
                break;

            case R.id.buttonC:
                comX = "";           // 컴퓨터가 낸 걸 보관하는 장소
                userX = "";          // 사람이 낸 걸 보관하는 장소
                resultX = "";        // 승패 결과를 보관하는 장소
                // 컴퓨터 가위 바위 보 선택
                r = new Random();
                f = r.nextFloat();
                if(f<0.333){
                    comX = "가위";
                } else if (f<0.666){
                    comX = "바위";
                } else {
                    comX = "보";
                }
                computer.setText(comX);     // 컴퓨터가 낸 걸 화면에 표시

                // 사람 가위 바위 보 선택 (누른 버튼에 따라)
                switch(v.getId()) {
                    case R.id.buttonA:
                        userX = "가위";
                        break;
                    case R.id.buttonB:
                        userX = "바위";
                        break;
                    case R.id.buttonC:
                        userX = "보";
                        break;
                }
                user.setText(userX);    // 사람이 낸 걸 화면에 표시

                // 컴퓨터랑 사람의 승패 결정
                if(userX.equals("가위")){     // 사람이 가위를 낸 경우
                    if(comX.equals("가위"))
                        resultX = "비겼어요!!";
                    else if (comX.equals("바위"))
                        resultX = "컴퓨터 승리!!";
                    else        // 컴퓨터가 보를 낸 경우
                        resultX = "플레이어 승리!!";
                } else if(userX.equals("바위")){  // 사람이 바위를 낸 경우
                    if(comX.equals("가위"))
                        resultX = "플레이어 승리!!";
                    else if (comX.equals("바위"))
                        resultX = "비겼어요!!";
                    else        // 컴퓨터가 보를 낸 경우
                        resultX = "컴퓨터 승리!!";
                } else if(userX.equals("보")){       // 사람이 보를 낸 경우
                    if(comX.equals("가위"))
                        resultX = "컴퓨터 승리!!";
                    else if (comX.equals("바위"))
                        resultX = "플레이어 승리!!";
                    else        // 컴퓨터가 보를 낸 경우
                        resultX = "비겼어요!!";
                }
                if (resultX.equals("플레이어 승리!!")){
                    if(userX.equals("가위")){
                        resultInt=resultInt+15;
                    }
                    else if(userX.equals("바위")){
                        resultInt=resultInt+5;
                    }
                    else if(userX.equals("보")){
                        resultInt=resultInt+25;
                    }
                }
                else if (resultX.equals("컴퓨터 승리!!")){
                    if(comX.equals("가위")){
                        resultInt=resultInt-15;
                    }
                    else if(comX.equals("바위")){
                        resultInt=resultInt-5;
                    }
                    else if(comX.equals("보")){
                        resultInt=resultInt-25;
                    }
                }
                result.setText(resultX);    // 승패 결과를 화면에 표시
                progress.setProgress(resultInt) ;
                textA.setText(" "+resultInt);
                break;










































        }





    }





}
