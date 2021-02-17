package com.aki.swaggertest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.net.MalformedURLException;

/**
 * 此方法用于输出 swagger 文档
 */
@RestController
@RequestMapping("/export")
@ApiIgnore
public class ExportController {
	@Value("${switch_swagger}")
	private boolean switch_swagger;

	@RequestMapping("/ascii")
	public String exportAscii() throws MalformedURLException {
		if (switch_swagger){
			SwaggerUtils.generateAsciiDocs();
			return "success";
		}
		return "failure";
	}

	@RequestMapping("/asciiToFile")
	public String asciiToFile() throws MalformedURLException{
		if (switch_swagger){
			SwaggerUtils.generateAsciiDocsToFile();
			return "success";
		}
		return "failure";
	}

	@RequestMapping("/markdown")
	public String exportMarkdown() throws MalformedURLException{
		if (switch_swagger){
			SwaggerUtils.generateMarkdownDocs();
			return "success";
		}
		return "failure";
	}

	@RequestMapping("/markdownToFile")
	public String exportMarkdownToFile() throws MalformedURLException{
		if (switch_swagger){
			SwaggerUtils.generateMarkdownDocsToFile();
			return "success";
		}
		return "failure";
	}

	@RequestMapping("/confluence")
	public String confluence() throws MalformedURLException{
		if (switch_swagger){
			SwaggerUtils.generateConfluenceDocs();
			return "success";
		}
		return "failure";
	}

	@RequestMapping("/confluenceToFile")
	public String confluenceToFile() throws MalformedURLException{
		if (switch_swagger){
			SwaggerUtils.generateConfluenceDocsToFile();
			return "success";
		}
		return "failure";
	}
}
