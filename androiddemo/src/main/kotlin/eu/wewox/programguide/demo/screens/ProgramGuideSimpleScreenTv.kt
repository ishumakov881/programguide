package eu.wewox.programguide.demo.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.tv.material3.Surface
import eu.wewox.programguide.ProgramGuide
import eu.wewox.programguide.ProgramGuideItem
import eu.wewox.programguide.demo.data.createPrograms
import eu.wewox.programguide.demo.ui.components.ChannelCellTv
import eu.wewox.programguide.demo.ui.components.ProgramCellTv
import eu.wewox.programguide.demo.ui.components.TimelineItemCellTv
import eu.wewox.programguide.rememberSaveableProgramGuideState
import kotlinx.coroutines.launch

/**
 * Showcases the most simple usage of program guide for Android TV.
 */
@Composable
fun ProgramGuideSimpleScreenTv() { // Removed onBackClick
    Surface(modifier = Modifier.fillMaxSize()) { // Using Surface for background
        val channels = 20
        val timeline = 8..22
        val programs = remember { createPrograms(channels, timeline) }

        val programGuideState = rememberSaveableProgramGuideState()
        ProgramGuide(
            modifier = Modifier.fillMaxSize(), // Fill max size
            state = programGuideState
        ) {
            guideStartHour = timeline.first.toFloat()

            programs(
                count = programs.size,
                layoutInfo = { index ->
                    val program = programs[index]
                    ProgramGuideItem.Program(
                        channelIndex = program.channel,
                        startHour = program.start,
                        endHour = program.end,
                    )
                },
                itemContent = { index ->
                    val program = programs[index]
                    val scope = rememberCoroutineScope()
                    ProgramCellTv(
                        program,
                        modifier = Modifier.onFocusChanged { focusState ->
                            if (focusState.isFocused) {
                                scope.launch {
                                    programGuideState.animateToProgram(index)
                                }
                            }
                        },
                        onClick = {

                        }
                    )
                },
            )

            channels(
                count = channels,
                layoutInfo = {
                    ProgramGuideItem.Channel(
                        index = it
                    )
                },
                itemContent = { index ->
                    val scope = rememberCoroutineScope()
                    ChannelCellTv(
                        index,
                        modifier = Modifier.onFocusChanged { focusState ->
                            if (focusState.isFocused) {
                                scope.launch {
                                    programGuideState.animateToChannel(index)
                                }
                            }
                        },
                        onClick = {

                        }
                    )
                },
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
                itemContent = { index ->
                    val scope = rememberCoroutineScope()
                    TimelineItemCellTv(
                        timeline.toList()[index].toFloat(),
                        modifier = Modifier.onFocusChanged { focusState ->
                            if (focusState.isFocused) {
                                scope.launch {
                                    programGuideState.animateToTimeline(index)
                                }
                            }
                        }
                    )
                },
            )
        }
    }
}
