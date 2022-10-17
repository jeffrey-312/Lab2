package com.example.a109360143_lab1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText ed_name;
    private TextView tv_text, tv_name, tv_winner, tv_my, tv_computer;
    private RadioButton btn_scissor, btn_stone, btn_paper;
    private Button btn_mora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //連接mx連接mxl的元件
        ed_name = findViewById(R.id.ed_name);
        tv_winner = findViewById(R.id.tv_winner);
        tv_text = findViewById(R.id.tv_text);
        tv_my = findViewById(R.id.tv_my);
        tv_computer = findViewById(R.id.tv_computer);
        tv_name = findViewById(R.id.tv_name);
        btn_mora = findViewById(R.id.btn_mora);
        btn_paper = findViewById(R.id.btn_paper);
        btn_scissor = findViewById(R.id.btn_scissor);
        btn_stone = findViewById(R.id.btn_stone);
        btn_mora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ed_name.length() < 1)
                    tv_text.setText("請輸入玩家姓名");
                else {
                    tv_name.setText(String.format("姓名\n%s", ed_name.getText().toString()));
                    if (btn_scissor.isChecked())
                        tv_computer.setText("我方出拳\n剪刀");
                    else if (btn_stone.isChecked())
                        tv_computer.setText("我方出拳\n石頭");
                    else
                        tv_computer.setText("我方出拳\n布");
                    int com_mora = (int) (Math.random() * 3);
                    if (com_mora == 0)
                        tv_computer.setText("電腦出拳\n剪刀");
                    else if (com_mora == 1)
                        tv_computer.setText("電腦出拳\n石頭");
                    else
                        tv_computer.setText("電腦出拳\n布");
                    if ((btn_scissor.isChecked() && com_mora == 2) || (btn_stone.isChecked() && com_mora == 0) || (btn_paper.isChecked() && com_mora == 1)) {
                        tv_winner.setText("勝利者\n" + ed_name.getText().toString());
                        tv_text.setText("恭喜你獲勝了！！！");
                    } else if ((btn_scissor.isChecked() && com_mora == 1) || (btn_stone.isChecked() && com_mora == 2) || (btn_paper.isChecked() && com_mora == 0)) {
                        tv_winner.setText("勝利者\n電腦" + ed_name.getText().toString());
                        tv_text.setText("可惜，電腦獲勝了！");
                    } else {
                        tv_winner.setText(("勝利者\n平手"));
                        tv_text.setText("平局，請再試一次！");
                    }
                }
            }
        });

    }

}