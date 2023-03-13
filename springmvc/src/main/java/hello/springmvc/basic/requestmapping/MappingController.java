package hello.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class MappingController {

    @RequestMapping({"/hello-basic", "/hello-go"})
    public String helloBasic() {
        log.info("helloBasic");
        return "okay";
    }

    @RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET)
    public String mappingGetV1(){
        log.info("mappingGetV1");
        return "OK";
    }


    @GetMapping(value = "/mapping-get-v2")
    public String mappingGetV2(){
        log.info("mappingGetV2");
        return "OK";
    }

    /**
     * PathVariable
     * you can omit it if the variable names are the same.
     * @PathVariable("userId") String userId -> @PathVariable userId
     */
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data){
        log.info("mappingPath userId = {}", data);
        return "OK";
    }
//    @GetMapping("/mapping/{userId}")
//    public String mappingPath(@PathVariable String userId){
//        log.info("mappingPath userId = {}", userId);
//        return "OK";
//    }


    /**
     * Multiple PathVariable
     */
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable Long orderId){
        log.info("mappingPath userId = {}", userId);
        log.info("mappingPath oderId = {}", orderId);
        return "OK";
    }

    /**
     * Params additional mapping
     * params = "mode",
     * params = "!mode",
     * params = "mode=debug",
     * params = "mode!=debug",
     * params = {"mode!=debug","data=good"}
     */
    //below will only work with http://localhost:8080/mapping-param?mode=debug
    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam(){
        log.info("mappingParam");
        return "OK";
    }

    /**
     * Header additional mapping
     * headers = "mode",
     * headers = "!mode",
     * headers = "mode=debug",
     * headers = "mode!=debug",
     * headers = {"mode!=debug","data=good"}
     */
    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingHeader(){
        log.info("mappingHeader");
        return "OK";
    }

    /**
     * Content-Type header based additional mapping ( Media Type)
     * consumes = "application/json",
     * consumes = "!application/json",
     * consumes = "application/*",
     * consumes = "*\/*",
     * MediaType.APPLICATION_JSON_VALUE
     *
     * produces must match Accept header
     */
    @PostMapping(value = "/mapping-consume",  consumes = "application/json")
    public String mappingConsumes(){
        log.info("mappingConsumes");
        return "OK";
    }

    /**
     * Accept header based additional mapping ( Media Type)
     * produces = "text/html",
     * produces = "text/plain",
     * produces = {"text/html,"application/*"},
     * produces = "!text/html",
     * produces = "text/html/*",
     * produces = MediaType.TEXT_PLAIN_VALUE
     * produces = "text/plain;charset=UTF-8",
     * produces = "*\/*",
     *
     * produces must match Accept header
     */
    @GetMapping(value = "/mapping-produce", produces = MediaType.TEXT_HTML_VALUE)
    public String mappingProduces(){
        log.info("mappingProduces");
        return "OK";
    }
}
