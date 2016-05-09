PAPER=report
LOCALLATEX = ../../latex
TEX = TEXINPUTS=./:$(LOCALLATEX):$(TEXINPUTS) pdflatex -interaction nonstopmode -halt-on-error

all: $(PAPER).pdf

clean:
-       rm -fv $(PAPER).aux $(PAPER).dvi $(PAPER).log $(PAPER).out $(PAPER).pdf

$(PAPER).pdf: $(PAPER).tex Minesweeper_java-kiviat-metrics-graph-original.png project-kiviat-metrics-graph-original.png project-kiviat-metrics-graph-final.png project-metrics-summary-original.png project-metrics-summary-final.png $(LOCALLATEX)/ifi-kompendium-forside-eng.png Minesweeper_java-kiviat-metrics-graph-final.png
	$(TEX) $(PAPER) 
