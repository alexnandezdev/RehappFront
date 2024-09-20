package com.example.rehapp_20.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rehapp_20.models.VideoDTO
import com.example.rehapp_20.repositories.VideoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class VideoViewModel @Inject constructor(
    private val videoRepository: VideoRepository
) : ViewModel() {

    private val TAG = "VideoViewModel"

    private val _videosResult = MutableLiveData<Response<List<VideoDTO>>>()
    val videosResult: LiveData<Response<List<VideoDTO>>> = _videosResult

    fun fetchVideosByModuleId(moduleId: Long) {
        Log.d(TAG, "fetchVideosByModuleId: Iniciando la solicitud para obtener videos del módulo $moduleId")
        viewModelScope.launch {
            try {
                val response = videoRepository.getVideosByModuleId(moduleId)
                Log.d(TAG, "fetchVideosByModuleId: Respuesta del servidor: $response")
                _videosResult.postValue(response)
            } catch (e: Exception) {
                Log.e(TAG, "fetchVideosByModuleId: Error al obtener los videos", e)
            }
        }
    }
}