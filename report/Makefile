PAPER=report
TEX = TEXINPUTS=./:./latex:$(TEXINPUTS) pdflatex -interaction nonstopmode

all: $(PAPER).pdf

clean:
	rm -fv $(PAPER).aux $(PAPER).log $(PAPER).dvi $(PAPER).pdf

$(PAPER).pdf: $(PAPER).tex
	$(TEX) $(PAPER) 
