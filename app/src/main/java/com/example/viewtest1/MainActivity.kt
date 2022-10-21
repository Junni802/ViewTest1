package com.example.viewtest1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.viewtest1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
	val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(binding.root)

		val customView = CustomView(this, "")
		binding.frameLayout.addView(customView)

		binding.bntPrint.setOnClickListener {
			binding.frameLayout.removeAllViews()
			val customView = CustomView(this, "${binding.txtString.text.toString()}")
			binding.frameLayout.addView(customView)
		}

	}
}

class CustomView(context: Context, name: String) : View(context) {
	val name: String
	init{
		this.name = name
	}
	override fun onDraw(canvas: Canvas?) {
	// 화면에 지정한 내용을 그려주는 함수
		super.onDraw(canvas)

		val paint = Paint()
		paint.color = Color.BLACK
		paint.textSize = 100f
		// textSize 프로퍼티의 자료형이 실수이므로 'f'를 붙여줌

		canvas?.drawText("${name}", 0f, 100f, paint)
		// text : 출력할 문자열, x : x좌표, y : y좌표, paint : 글자 속성
		// 좌표는 문자열의 좌측 하단이 기준점
		// 단, 화면의 기준은 좌상단이므로 y좌표 값을 최소 텍스트 크기보다 크게 춰야함
	}
}
