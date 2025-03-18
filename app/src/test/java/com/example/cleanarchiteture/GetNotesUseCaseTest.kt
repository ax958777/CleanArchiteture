package com.example.cleanarchiteture

import com.example.cleanarchiteture.domain.model.Note
import com.example.cleanarchiteture.domain.repository.NoteRepository
import com.example.cleanarchiteture.domain.use_case.GetNotesUseCase
import com.google.common.truth.Truth.assertThat
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class GetNotesUseCaseTest {
    private lateinit var repository:NoteRepository
    private lateinit var getNotesUseCase: GetNotesUseCase

    @Before
    fun setup(){
        repository= mockk()
        getNotesUseCase=GetNotesUseCase(repository)
    }

    @Test
    fun `get notes return ordered list from repository` () = runTest {
        //Given
        val notes= listOf(
            Note(1,"title1", "content1",2),
            Note(2,"title2", "content2",1),
        )
        coEvery { repository.getNotes() } returns  notes

        //When
        val result=getNotesUseCase()

        //Then
        assertThat(result).isEqualTo(notes)
        coVerify { repository.getNotes() }
    }

}