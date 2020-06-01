export const data = {
    _embedded: {
        features: [
            {
                id: 1,
                displayName: 'test1',
                technicalName: 'test1',
                expiresOn: null,
                description: 'description1',
                inverted: false,
                _links: {
                    self: {
                        href: 'http://localhost:8080/api/v1/features/1'
                    },
                    featureToggle: {
                        href: 'http://localhost:8080/api/v1/features/1'
                    }
                }
            },
            {
                id: 2,
                displayName: 'test2',
                technicalName: 'test2',
                expiresOn: null,
                description: 'description2',
                inverted: false,
                _links: {
                    self: {
                        href: 'http://localhost:8080/api/v1/features/2'
                    },
                    featureToggle: {
                        href: 'http://localhost:8080/api/v1/features/2'
                    }
                }
            }
        ]
    },
    _links: {
        first: {
            href: 'http://localhost:8080/api/v1/features?page=0&size=20'
        },
        self: {
            href: 'http://localhost:8080/api/v1/features'
        },
        next: {
            href: 'http://localhost:8080/api/v1/features?page=1&size=20'
        },
        last: {
            href: 'http://localhost:8080/api/v1/features?page=1&size=20'
        },
        profile: {
            href: 'http://localhost:8080/api/v1/profile/features'
        }
    },
    page: {
        size: 20,
        totalElements: 2,
        totalPages: 1,
        number: 0
    }
};