package com.crud.tasks.mapper;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloCard;
import com.crud.tasks.domain.TrelloList;
import com.crud.tasks.trello.client.TrelloBoardDto;
import com.crud.tasks.trello.client.TrelloCardDto;
import com.crud.tasks.trello.client.TrelloListDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TrelloMapperTestSuite {
    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    void mapToBoards() {
        //Given
        TrelloListDto trelloListDto1 = new TrelloListDto("test_list_id1", "test_list_name1", true);
        TrelloListDto trelloListDto2 = new TrelloListDto("test_list_id2", "test_list_name2", false);
        List<TrelloListDto> list = new ArrayList<>();
        list.add(trelloListDto1);
        list.add(trelloListDto2);
        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("test_id", "test_name", list);
        List<TrelloBoardDto> boardDtoList = new ArrayList<>();
        boardDtoList.add(trelloBoardDto);

        //When
        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(boardDtoList);

        //Then
        assertAll(
                () -> assertEquals(1, trelloBoards.size()),
                () -> assertEquals("test_id", trelloBoards.get(0).getId()),
                () -> assertEquals("test_name", trelloBoards.get(0).getName()),
                () -> assertEquals(2, trelloBoards.get(0).getLists().size())
        );
    }

    @Test
    void mapToBoardsDto() {
        //Given
        TrelloList trelloList1 = new TrelloList("test_list_id1", "test_list_name1", true);
        TrelloList trelloList2 = new TrelloList("test_list_id2", "test_list_name2", false);
        List<TrelloList> list = new ArrayList<>();
        list.add(trelloList1);
        list.add(trelloList2);
        TrelloBoard trelloBoard = new TrelloBoard("test_id", "test_name", list);
        List<TrelloBoard> boardList = new ArrayList<>();
        boardList.add(trelloBoard);

        //When
        List<TrelloBoardDto> trelloBoardDtos = trelloMapper.mapToBoardsDto(boardList);

        //Then
        assertAll(
                () -> assertEquals(1, trelloBoardDtos.size()),
                () -> assertEquals("test_id", trelloBoardDtos.get(0).getId()),
                () -> assertEquals("test_name", trelloBoardDtos.get(0).getName()),
                () -> assertEquals(2, trelloBoardDtos.get(0).getLists().size())
        );
    }

    @Test
    void mapToList() {
        //Given
        TrelloListDto trelloListDto1 = new TrelloListDto("test_list_id", "test_list_name", true);
        List<TrelloListDto> list = new ArrayList<>();
        list.add(trelloListDto1);

        //When
        List<TrelloList> trelloList = trelloMapper.mapToList(list);

        //Then
        assertAll(
                () -> assertEquals(1, trelloList.size()),
                () -> assertEquals("test_list_id", trelloList.get(0).getId()),
                () -> assertEquals("test_list_name", trelloList.get(0).getName()),
                () -> assertTrue(trelloList.get(0).isClosed())
        );
    }

    @Test
    void mapToListDto() {
        //Given
        TrelloList trelloList = new TrelloList("test_list_id", "test_list_name", true);
        List<TrelloList> list = new ArrayList<>();
        list.add(trelloList);

        //When
        List<TrelloListDto> trelloListDtos = trelloMapper.mapToListDto(list);

        //Then
        assertAll(
                () -> assertEquals(1, trelloListDtos.size()),
                () -> assertEquals("test_list_id", trelloListDtos.get(0).getId()),
                () -> assertEquals("test_list_name", trelloListDtos.get(0).getName()),
                () -> assertTrue(trelloListDtos.get(0).isClosed())
        );
    }

    @Test
    void mapToCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard("test_name", "test_description", "test_pos", "test_list_id");

        //When
        TrelloCardDto cardDto = trelloMapper.mapToCardDto(trelloCard);

        //Then
        assertAll(
                () -> assertEquals("test_name", cardDto.getName()),
                () -> assertEquals("test_description", cardDto.getDescription()),
                () -> assertEquals("test_pos", cardDto.getPos()),
                () -> assertEquals("test_list_id", cardDto.getListId())
        );
    }

    @Test
    void mapToCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("test_name", "test_description", "test_pos", "test_list_id");

        //When
        TrelloCard card = trelloMapper.mapToCard(trelloCardDto);

        //Then
        assertAll(
                () -> assertEquals("test_name", card.getName()),
                () -> assertEquals("test_description", card.getDescription()),
                () -> assertEquals("test_pos", card.getPos()),
                () -> assertEquals("test_list_id", card.getListId())
        );
    }
}