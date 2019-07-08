package com.bytedance.android.lesson.restapi.solution;


import com.bytedance.android.lesson.restapi.solution.bean.Note;

/**
 * Created on 2019/1/23.
 *
 * @author xuyingyi@bytedance.com (Yingyi Xu)
 */
public interface NoteOperator {

    void deleteNote(Note note);

    void updateNote(Note note);
}

