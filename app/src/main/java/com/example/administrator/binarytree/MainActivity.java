package com.example.administrator.binarytree;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.tencent.tinker.lib.tinker.TinkerInstaller;

import Entry.ListEntity;
import view.BinaryView;

public class MainActivity extends AppCompatActivity {

   TextView tv_bug_te;
    BinaryView mBinaryTreeView;
    Button btn_repair;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBinaryTreeView = (BinaryView)findViewById(R.id.mBinaryTreeView);
        tv_bug_te=(TextView)findViewById(R.id.tv_bug_test);
        btn_repair=(Button)findViewById(R.id.btn_repair);
        initData();
        btn_repair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {

                    TinkerInstaller.onReceiveUpgradePatch(getApplicationContext(), Environment.getExternalStorageDirectory().getAbsolutePath() + "/patch_signed_7zip.apk");
                }catch (Exception e)
                {

                    e.printStackTrace();
                }

            }
        });
    }

    private void  initData()
    {
        String result="{\n" +
                "    \"entity\": {\n" +
                "        \"eliminationList\": [\n" +
                "            [\n" +
                "                {\n" +
                "                    \"member\": {\n" +
                "                        \"name\": \"大一\",\n" +
                "                        \"score\": 6,\n" +
                "                        \"teammateNameList\": [],\n" +
                "                        \"userId\": \"123456789\"\n" +
                "                    }\n" +
                "                },\n" +
                "                {\n" +
                "                    \"member\": {\n" +
                "                        \"name\": \"大二\",\n" +
                "                        \"score\": 1,\n" +
                "                        \"teammateNameList\": [],\n" +
                "                        \"userId\": \"123456789\"\n" +
                "                    }\n" +
                "                },\n" +
                "                {\n" +
                "                    \"member\": {\n" +
                "                        \"name\": \"大三\",\n" +
                "                        \"score\": 3,\n" +
                "                        \"teammateNameList\": [],\n" +
                "                        \"userId\": \"123456789\"\n" +
                "                    }\n" +
                "                },\n" +
                "                {\n" +
                "                    \"member\": {\n" +
                "                        \"name\": \"大四\",\n" +
                "                        \"score\": 6,\n" +
                "                        \"teammateNameList\": [],\n" +
                "                        \"userId\": \"123456789\"\n" +
                "                    }\n" +
                "                },\n" +
                "                {\n" +
                "                    \"member\": {\n" +
                "                        \"name\": \"二一\",\n" +
                "                        \"score\": 6,\n" +
                "                        \"teammateNameList\": [],\n" +
                "                        \"userId\": \"123456789\"\n" +
                "                    }\n" +
                "                },\n" +
                "                {\n" +
                "                    \"member\": {\n" +
                "                        \"name\": \"二二\",\n" +
                "                        \"score\": 0,\n" +
                "                        \"teammateNameList\": [],\n" +
                "                        \"userId\": \"123456789\"\n" +
                "                    }\n" +
                "                },\n" +
                "                {\n" +
                "                    \"member\": {\n" +
                "                        \"name\": \"二三\",\n" +
                "                        \"score\": 3,\n" +
                "                        \"teammateNameList\": [],\n" +
                "                        \"userId\": \"123456789\"\n" +
                "                    }\n" +
                "                },\n" +
                "                {\n" +
                "                    \"member\": {\n" +
                "                        \"name\": \"二四\",\n" +
                "                        \"score\": 6,\n" +
                "                        \"teammateNameList\": [],\n" +
                "                        \"userId\": \"123456789\"\n" +
                "                    }\n" +
                "                }\n" +
                "            ],\n" +
                "            [\n" +
                "                {\n" +
                "                    \"member\": {\n" +
                "                        \"name\": \"大一\",\n" +
                "                        \"score\": 6,\n" +
                "                        \"teammateNameList\": [],\n" +
                "                        \"userId\": \"123456789\"\n" +
                "                    }\n" +
                "                },\n" +
                "                {\n" +
                "                    \"member\": {\n" +
                "                        \"name\": \"大三\",\n" +
                "                        \"score\": 4,\n" +
                "                        \"teammateNameList\": [],\n" +
                "                        \"userId\": \"123456789\"\n" +
                "                    }\n" +
                "                },\n" +
                "                {\n" +
                "                    \"member\": {\n" +
                "                        \"name\": \"二二\",\n" +

                "                        \"score\": 5,\n" +
                "                        \"teammateNameList\": [],\n" +
                "                        \"userId\": \"123456789\"\n" +
                "                    }\n" +
                "                },\n" +
                "                {\n" +
                "                    \"member\": {\n" +
                "                        \"name\": \"二四\",\n" +
                "                        \"score\": 7,\n" +
                "                        \"teammateNameList\": [],\n" +
                "                        \"userId\": \"123456789\"\n" +
                "                    }\n" +
                "                }\n" +
                "            ],\n" +
                "            [\n" +
                "                {\n" +
                "                    \"member\": {\n" +
                "                        \"name\": \"大一\",\n" +
                "                        \"score\": 6,\n" +
                "                        \"teammateNameList\": [],\n" +
                "                        \"userId\": \"123456789\"\n" +
                "                    },\n" +
                "                    \"smallscore\": 4\n" +
                "                },\n" +
                "                {\n" +
                "                    \"member\": {\n" +
                "                        \"name\": \"二四\",\n" +
                "                        \"score\": 7,\n" +
                "                        \"teammateNameList\": [],\n" +
                "                        \"userId\": \"123456789\"\n" +
                "                    }\n" +
                "                }\n" +
                "            ],\n" +
                "            [\n" +
                "                {\n" +
                "                    \"member\": {\n" +
                "                        \"name\": \"二四\",\n" +
                "                        \"teammateNameList\": [],\n" +
                "                        \"userId\": \"123456789\"\n" +
                "                    }\n" +
                "                },\n" +
                "                {\n" +
                "                    \"member\": {\n" +
                "                        \"name\": \"大一\",\n" +
                "                        \"teammateNameList\": [],\n" +
                "                        \"userId\": \"123456789\"\n" +
                "                    }\n" +
                "                }\n" +
                "            ]\n" +
                "        ]\n" +
                "    }\n" +
                "}";
        Gson gson = new Gson();
        ListEntity person = gson.fromJson(result,ListEntity.class);
        mBinaryTreeView.setData(BinaryView.TYPE_SINGLE, person.getEntity().getEliminationList());
        Log.e("person",String.valueOf(person.getEntity().getEliminationList()));

    }
}
