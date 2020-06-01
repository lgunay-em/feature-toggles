import { TestBed, async } from '@angular/core/testing';
import { FeaturesService } from './features.service';
import { MatDialog } from '@angular/material/dialog';
import { FeaturesComponent } from './features.component';
import { of } from 'rxjs';

describe('FeaturesComponent', () => {
    let featuresService: any;
    let dialog: any;
    let featuresComponent: FeaturesComponent;

    beforeEach(async(() => {
        featuresService = jasmine.createSpyObj('FeaturesService', ['getAll']);
        dialog = jasmine.createSpyObj('FeaturesService', ['open']);

        featuresComponent = new FeaturesComponent(featuresService, dialog);
    }));

    it('should initiate correctly', () => {
        expect(featuresComponent).toBeDefined();
        expect(featuresService.getAll.calls.count()).toBe(1);
    })

    it('should paginate correctly', () => {
        const returnValue = of({ someData: 'some data'});
        featuresService.getAll.and.returnValue(returnValue);

        featuresComponent.paginate({ pageIndex: 3 });

        expect(featuresComponent.currentPage).toBe(3);
        expect(featuresComponent.data$).toBe(returnValue);

        expect(featuresService.getAll.calls.count()).toBe(2);
    });
});
