package app.kaidonav.editor;

import androidx.annotation.Nullable;

interface TimetableChangedListener
{
  void onTimetableChanged(@Nullable String timetable);
}
