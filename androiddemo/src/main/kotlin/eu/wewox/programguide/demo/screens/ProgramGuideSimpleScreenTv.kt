package eu.wewox.programguide.demo.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.tv.material3.Surface
import eu.wewox.programguide.ProgramGuide
import eu.wewox.programguide.ProgramGuideItem
import eu.wewox.programguide.demo.data.createPrograms
import eu.wewox.programguide.demo.ui.components.ChannelCellTv
import eu.wewox.programguide.demo.ui.components.ProgramCellTv
import eu.wewox.programguide.demo.ui.components.TimelineItemCellTv

/**
 * Showcases the most simple usage of program guide for Android TV.
 */
@Composable
fun ProgramGuideSimpleScreenTv() { // Removed onBackClick
    Surface(modifier = Modifier.fillMaxSize()) { // Using Surface for background
        val channels = 20
        val timeline = 8..22
        val programs = remember { createPrograms(channels, timeline) }

        ProgramGuide(
            modifier = Modifier.fillMaxSize() // Fill max size
        ) {
            guideStartHour = timeline.first.toFloat()

            programs(
                items = programs,
                layoutInfo = {
                    ProgramGuideItem.Program(
                        channelIndex = it.channel,
                        startHour = it.start,
                        endHour = it.end,
                    )
                },
                itemContent = { ProgramCellTv(it) },
            )

            channels(
                count = channels,
                layoutInfo = {
                    ProgramGuideItem.Channel(
                        index = it
                    )
                },
                itemContent = { ChannelCellTv(it) },
            )

            timeline(
                count = timeline.count(),
                layoutInfo = {
                    val start = timeline.toList()[it].toFloat()
                    ProgramGuideItem.Timeline(
                        startHour = start,
                        endHour = start + 1f
                    )
                },
                itemContent = { TimelineItemCellTv(timeline.toList()[it].toFloat()) },
            )
        }
    }
}
