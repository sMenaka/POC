package lk.fileuploader;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class FileUploaderPocApplicationTests {
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Test
    void mp4FileUpload() throws Exception {

        byte[] data = new byte[] {1, 2, 3, 4};
        MockMultipartFile file = new MockMultipartFile("file","test.mp4", String.valueOf(MediaType.MULTIPART_FORM_DATA),
                data);
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        mockMvc.perform(multipart("/upload/video").file(file)).andExpect(status().isOk());

    }
    @Test
    void wmvFileUpload() throws Exception {

        byte[] data = new byte[] {1, 2, 3, 4};
        MockMultipartFile file = new MockMultipartFile("file","test.wmv", String.valueOf(MediaType.MULTIPART_FORM_DATA),
                data);
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        mockMvc.perform(multipart("/upload/video").file(file)).andExpect(status().isOk());

    }

    @Test
    void aviFileUpload() throws Exception {

        byte[] data = new byte[] {1, 2, 3, 4};
        MockMultipartFile file = new MockMultipartFile("file","test.avi", String.valueOf(MediaType.MULTIPART_FORM_DATA),
                data);
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        mockMvc.perform(multipart("/upload/video").file(file)).andExpect(status().isNotAcceptable());

    }

    @Test
    void jpgFileUpload() throws Exception {

        byte[] data = new byte[] {1, 2, 3, 4};
        MockMultipartFile file = new MockMultipartFile("file","test.jpg", String.valueOf(MediaType.MULTIPART_FORM_DATA),
                data);
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        mockMvc.perform(multipart("/upload/image").file(file)).andExpect(status().isOk());

    }

    @Test
    void pngFileUpload() throws Exception {

        byte[] data = new byte[] {1, 2, 3, 4};
        MockMultipartFile file = new MockMultipartFile("file","test.png", String.valueOf(MediaType.MULTIPART_FORM_DATA),
                data);
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        mockMvc.perform(multipart("/upload/image").file(file)).andExpect(status().isOk());

    }
}
