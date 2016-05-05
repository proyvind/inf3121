PAPER=report
LOCALLATEX = ../../latex
TEX = TEXINPUTS=./:$(LOCALLATEX):$(TEXINPUTS) pdflatex -interaction nonstopmode -halt-on-error

all: $(PAPER).pdf

clean:
	rm -fv $(PAPER).aux $(PAPER).dvi $(PAPER).log $(PAPER).out $(PAPER).pdf

$(PAPER).pdf: $(PAPER).tex
	$(TEX) $(PAPER) 
