package com.example.bob_modules

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.jocata.bob.utils.buildType
import com.jocata.bob.utils.customerID
import com.jocata.bob.utils.sessionID
import com.jocata.bob.utils.sessionToken
import com.jocata.bob_el_android.MainActivity
import com.jocata.bobhl.BobMainActivity

class BobModuleMainActivity : AppCompatActivity() {
    private lateinit var btnGo : Button
    private lateinit var btnGoPlMl : Button
    private lateinit var btnGoEL : Button
    private lateinit var btnGoAL : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bob_module_main)

        btnGo = findViewById(R.id.btnGo)
        btnGoPlMl = findViewById(R.id.btnGoPlMl)
        btnGoEL = findViewById(R.id.btnGoEL)
        btnGoAL = findViewById(R.id.btnGoAL)

        btnGo.setOnClickListener {
            openFlowForUAT(com.jocata.bob.data.model.BobPLMLFlowTypeValues.HML.name, true, "")
            /*val intent = Intent(this@BobModuleMainActivity,BobMainActivity::class.java).apply {
                putExtra(BobPLMLParamKeys.FLOW_TYPE.name, BobPLMLFlowTypeValues.HML.name)
                putExtra(BobPLMLParamKeys.BUILD_TYPE.name, "uat")
            }
            startActivity(intent)*/
        }

        btnGoPlMl.setOnClickListener {
            openFlowForUAT(BobPLMLFlowTypeValues.PL.name, true, "")

            /*val intent = Intent(this@BobModuleMainActivity,com.jocata.bob.BobMainActivity::class.java).apply {
                putExtra(BobPLMLParamKeys.FLOW_TYPE.name, BobPLMLFlowTypeValues.PL.name)
                putExtra(BobPLMLParamKeys.BUILD_TYPE.name, "uat")
            }

            startActivity(intent)*/
        }

        btnGoEL.setOnClickListener {
            /*val intent = Intent(this@BobModuleMainActivity, MainActivity::class.java).apply {
                putExtra(BobPLMLParamKeys.FLOW_TYPE.name, BobPLMLFlowTypeValues.EL.name)
                putExtra(BobPLMLParamKeys.BUILD_TYPE.name, "uat")
            }

            startActivity(intent)*/
        }

        btnGoAL.setOnClickListener {
            val intent = Intent(this@BobModuleMainActivity, com.example.bob_al_android.MainActivity::class.java).apply {
                putExtra(BobPLMLParamKeys.FLOW_TYPE.name, BobPLMLFlowTypeValues.AL.name)
                putExtra(BobPLMLParamKeys.BUILD_TYPE.name, "uat")
            }

            startActivity(intent)
        }
    }

    private fun openFlowForProduction(
        flowType: String,
        isPostLogin: Boolean = false,
        test_post_login: String
    ) {
        buildType = "production"
        val intent = Intent(this, if (flowType== BobPLMLFlowTypeValues.HML.name) BobMainActivity::class.java else com.jocata.bob.BobMainActivity::class.java).apply {
            putExtra(BobPLMLParamKeys.FLOW_TYPE.name, flowType)
            if (isPostLogin) {
                if (test_post_login == "POST_LOGIN") {
                    putExtra(BobPLMLParamKeys.CUSTOMER_ID.name, customerID)
                    putExtra(BobPLMLParamKeys.SESSION_ID.name, sessionID)
                    putExtra(BobPLMLParamKeys.SESSION_TOKEN.name, sessionToken)
                    putExtra(BobPLMLParamKeys.BUILD_TYPE.name, buildType)
                } else {
                    putExtra(BobPLMLParamKeys.CUSTOMER_ID.name, "")
                    putExtra(BobPLMLParamKeys.SESSION_ID.name, "")
                    putExtra(BobPLMLParamKeys.SESSION_TOKEN.name, "")
                    putExtra(BobPLMLParamKeys.BUILD_TYPE.name, buildType)
                    putExtra(BobPLMLParamKeys.SUB_SYSTEM_CODE.name, "")
                }
            }
        }
        startActivity(intent)
    }

    private fun openFlowForUAT(
        flowType: String,
        isPostLogin: Boolean = false,
        test_post_login: String,
    ) {
        buildType = "uat"
        val intent = Intent(this, if (flowType== com.jocata.bob.data.model.BobPLMLFlowTypeValues.HML.name) BobMainActivity::class.java else com.jocata.bob.BobMainActivity::class.java).apply {
            putExtra(com.jocata.bob.data.model.BobPLMLParamKeys.FLOW_TYPE.name, flowType)
            if (isPostLogin) {
                if (test_post_login == "POST_LOGIN") {
                    putExtra(BobPLMLParamKeys.CUSTOMER_ID.name, customerID)
                    putExtra(BobPLMLParamKeys.SESSION_ID.name, sessionID)
                    putExtra(BobPLMLParamKeys.SESSION_TOKEN.name, sessionToken)
                    putExtra(BobPLMLParamKeys.BUILD_TYPE.name, buildType)
                } else {
                    putExtra(BobPLMLParamKeys.CUSTOMER_ID.name, "")
                    putExtra(BobPLMLParamKeys.SESSION_ID.name, "")
                    putExtra(BobPLMLParamKeys.SESSION_TOKEN.name, "")
                    putExtra(BobPLMLParamKeys.BUILD_TYPE.name, buildType)
                    putExtra(BobPLMLParamKeys.SUB_SYSTEM_CODE.name, "")
                }
            }
        }
        startActivity(intent)
    }
}