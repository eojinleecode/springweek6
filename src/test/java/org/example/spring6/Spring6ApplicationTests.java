
package org.example.spring6;

import org.example.spring6.service.ClubActivityService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ClubActivityWebControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ClubActivityService service;

    @Test
    void formDataShouldBeSaved() throws Exception {

        int before = service.findAll().size();

        mockMvc.perform(post("/activities")
                        .param("title", "가을 정기 러닝")
                        .param("clubName", "한동 러닝 동아리")
                        .param("category", "운동")
                        .param("activityDate", "2026-10-15")
                        .param("location", "영일대 해수욕장")
                        .param("participants", "15")
                        .param("description", "정기 러닝"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/activities"));

        assertThat(service.findAll()).hasSize(before + 1);
    }
    @Test
    void shouldRedirectAfterCreation() throws Exception {
        mockMvc.perform(post("/activities")
                        .param("title", "PRG 테스트")
                        .param("clubName", "테스트 동아리")
                        .param("category", "운동")
                        .param("activityDate", "2026-10-16")
                        .param("location", "한동대학교")
                        .param("participants", "10")
                        .param("description", "PRG 패턴 테스트"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/activities"));
    }
}
