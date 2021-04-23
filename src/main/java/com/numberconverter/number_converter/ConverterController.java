package com.numberconverter.number_converter;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path="/api")
public class ConverterController {

    @Autowired
    private ConverterRepository converterRepository;
    Converter converter = new Converter();
    @Operation(summary = "Return binary number from decimal format")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found number",
                    content = { @Content(mediaType = "application/json",
                           // model= @ModelAttribute(implementation = Converter.class),
                            schema = @Schema(implementation = ConverterResult.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid number supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Number not found",
                    content = @Content) })
    @GetMapping(path="/binary/{number}")
    public @ResponseBody ConverterResult getBinary(@PathVariable ("number") int number) {
        ConverterEntity converterEntity = new ConverterEntity() ;
        ConverterResult converterresult = new ConverterResult();
        converter.setBinaryString(number);
        converterEntity.setInput(number);
        converterEntity.setOutput(converter.getString());
        converterEntity.setConversionType("Binary");
        converterRepository.save(converterEntity);
        converterresult.setResult(converterEntity.getOutput());
        return converterresult;
    }

    @Operation(summary = "Switching digits and returned it in octal system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found number",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ConverterResult.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid number supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Number not found",
                    content = @Content) })
    @GetMapping(path="/switchdigits/{number}")
    public @ResponseBody ConverterResult getSwitchDigits(@PathVariable ("number") int number) {
        ConverterEntity converterEntity = new ConverterEntity() ;
        ConverterResult converterresult = new ConverterResult();
        converter.setOctalString(number);
        converterEntity.setInput(number);
        converterEntity.setOutput(converter.getString());
        converterEntity.setConversionType("SwitchDigits");
        converterRepository.save(converterEntity);
        converterresult.setResult(converterEntity.getOutput());
        return converterresult;
    }

    @Operation(summary = "Reversing digits and returned it in hexadecimal format")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found number",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ConverterResult.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid number supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Number not found",
                    content = @Content) })
    @GetMapping(path="/reversedigits/{number}")
    public @ResponseBody ConverterResult getReverseDigits(@PathVariable ("number") int number) {
        ConverterEntity converterEntity = new ConverterEntity() ;
        ConverterResult converterresult = new ConverterResult();
        converter.setHexadecimalString(number);
        converterEntity.setInput(number);
        converterEntity.setOutput(converter.getString());
        converterEntity.setConversionType("ReverseDigits");
        converterRepository.save(converterEntity);
        converterresult.setResult(converterEntity.getOutput());
        return converterresult;
    }

    @Operation(summary = "Moving every 1s to the left, and all 0s to the right from the number and returning in decimal format ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found number",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ConverterResult.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid number supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Number not found",
                    content = @Content) })
    @GetMapping(path="/movingdigits/{number}")
    public @ResponseBody ConverterResult getMovingDigits(@PathVariable ("number") int number) {
        ConverterEntity converterEntity = new ConverterEntity() ;
        ConverterResult converterresult = new ConverterResult();
        converter.setDecimalString(number);
        converterEntity.setInput(number);
        converterEntity.setOutput(converter.getString());
        converterEntity.setConversionType("MovingDigits");
        converterRepository.save(converterEntity);
        converterresult.setResult(converterEntity.getOutput());
        return converterresult;
    }

    @Operation(summary = "Listing every record from repository")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found number",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ConverterEntity.class)) }),
            @ApiResponse(responseCode = "404", description = "Number not found",
                    content = @Content) })
    @GetMapping(path="/all")
    public @ResponseBody
    List<ConverterEntity> getAllConvert() {
        return converterRepository.findAll();
    }
}