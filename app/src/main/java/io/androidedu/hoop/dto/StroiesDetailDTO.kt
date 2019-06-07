package io.androidedu.hoop.dto

data class StroiesDetailDTO(val summary:String,
                            val images:ArrayList<MediaImagesDTO>,
                            val source:SourcesDTO,
                            val media:ArrayList<MediaImagesDTO>,
                            val updateDate:String,
                            val title:String,
                            val url:String,
                            val content:String
                            )