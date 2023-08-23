package com.google.mediapipe.examples.handlandmarker.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import com.google.mediapipe.examples.handlandmarker.R
import com.google.mediapipe.examples.handlandmarker.databinding.FragmentWebBinding

class WebFragment : Fragment() {
    private var _fragmentWebBinding: FragmentWebBinding? = null

    private val fragmentWebBinding
        get() = _fragmentWebBinding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _fragmentWebBinding = FragmentWebBinding.inflate(inflater, container, false)
        return fragmentWebBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentWebBinding.webView.settings.javaScriptEnabled = true
        fragmentWebBinding.webView.settings.javaScriptCanOpenWindowsAutomatically = true
        fragmentWebBinding.webView.settings.loadsImagesAutomatically = true
        fragmentWebBinding.webView.settings.cacheMode = WebSettings.LOAD_NO_CACHE
        fragmentWebBinding.webView.settings.setAppCacheEnabled(false) // ServiceWorker 로 마이그레이션 진행해야함.
        fragmentWebBinding.webView.settings.domStorageEnabled = true
        fragmentWebBinding.webView.settings.allowFileAccess = true
        fragmentWebBinding.webView.settings.allowFileAccessFromFileURLs = true
        fragmentWebBinding.webView.settings.allowUniversalAccessFromFileURLs = true
        fragmentWebBinding.webView.settings.loadWithOverviewMode = true
        fragmentWebBinding.webView.settings.mediaPlaybackRequiresUserGesture = false
        fragmentWebBinding.webView.loadUrl("https://codepen.io/mediapipe-preview/full/gOKBGPN")
    }
}